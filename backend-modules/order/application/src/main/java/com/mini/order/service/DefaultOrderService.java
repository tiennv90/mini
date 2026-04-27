package com.mini.order.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mini.order.component.ItemLineDataLoader;
import com.mini.order.domain.ItemLineDomain;
import com.mini.order.domain.OrderDomain;
import com.mini.order.dto.OrderDetailDTO;
import com.mini.order.dto.ParcelDTO;
import com.mini.order.dto.ShipmentDTO;
import com.mini.order.gateway.ParcelGateway;
import com.mini.order.gateway.ShipmentGateway;
import com.mini.order.mapper.OrderDomainMapper;
import com.mini.order.repository.OrderDomainRepository;

import shipping.mini.kernal.exception.EntityNotfoundException;

@Service
public class DefaultOrderService implements OrderService {

	private final OrderDomainRepository orderRepository;
	private final ParcelGateway parcelGateway;
	private final ItemLineDataLoader itemLineLoader;
	private final ShipmentGateway shipmentGateway;
	private final OrderDomainMapper orderDomainMapper;

	public DefaultOrderService(OrderDomainRepository orderRepository, ParcelGateway parcelGateway,
			ItemLineDataLoader itemLineLoader,
			ShipmentGateway shipmentGateway,
			OrderDomainMapper orderDomainMapper) {
		
		this.orderRepository = orderRepository;
		this.itemLineLoader = itemLineLoader;
		this.shipmentGateway = shipmentGateway;
		this.orderDomainMapper = orderDomainMapper;
		this.parcelGateway = parcelGateway;
	}

	@Override
	@Cacheable(value = "MINI_ORDER", key = "#id", cacheManager = "cacheManager")
	public OrderDetailDTO getOrderDetails(Long id) throws EntityNotfoundException {
		OrderDomain order = getOrder(id);
		List<ItemLineDomain> itemLines = itemLineLoader.loadAsList(List.of(id));

		List<ParcelDTO> parcels = null;
		ShipmentDTO shipment =  shipmentGateway.getShipmentByOrderId(order.getId());
		if  (shipment != null) {
			parcels = parcelGateway.getParcelsByShipmentId(shipment.id());
		}
		
		return orderDomainMapper.mapToOrderDetailDTO(order, itemLines,shipment, parcels);
	}

	private OrderDomain getOrder(Long id) throws EntityNotfoundException {
		return orderRepository.findById(id);
	}
}
