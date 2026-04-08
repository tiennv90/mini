package com.mini.order.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mini.order.domain.AddressDomain;
import com.mini.order.domain.ItemLineDomain;
import com.mini.order.domain.OrderDomain;
import com.mini.order.dto.ItemLineDTO;
import com.mini.order.dto.OrderDetailDTO;
import com.mini.order.dto.ParcelDTO;
import com.mini.order.dto.ShipmentDTO;
import com.mini.order.dto.request.CreateOrderRequest;

@Component
public class OrderDomainMapper {

	private final AddressDomainMapper addressMapper;
	private final ItemLineDomainMapper itemLineMapper;
	
	public OrderDomainMapper(AddressDomainMapper addressMapper, ItemLineDomainMapper itemLineMapper) {
		this.addressMapper = addressMapper;
		this.itemLineMapper = itemLineMapper;
	}
	
	public OrderDomain mapToOrderDO(CreateOrderRequest request, AddressDomain address, List<ItemLineDomain> items) {
		OrderDomain domain = new OrderDomain();
		domain.setDeliveryAddress(address);
		domain.setItemlines(items);
		domain.setExternalOrderNumber(request.externalOrderNumber());
		return domain;
	}

	public OrderDetailDTO mapToOrderDetailDTO(OrderDomain order, List<ItemLineDomain> itemLines, ShipmentDTO shipment,
			List<ParcelDTO> parcels) {
		List<ItemLineDTO> itemLineDTOs = null;
		if (itemLines != null) {
			itemLineDTOs = itemLines.stream().map(itemLineMapper::toDTO).collect(Collectors.toList());
		}
		return new OrderDetailDTO(order.getId(), 
				order.getExternalOrderNumber(), 
				order.getOrderStatus(), 
				addressMapper.toDTO(order.getDeliveryAddress()), itemLineDTOs, shipment, parcels);
	}

}
