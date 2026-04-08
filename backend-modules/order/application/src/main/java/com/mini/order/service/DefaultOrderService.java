package com.mini.order.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mini.order.component.ItemLineDataLoader;
import com.mini.order.component.ParcelDataLoader;
import com.mini.order.domain.AddressDomain;
import com.mini.order.domain.ItemLineDomain;
import com.mini.order.domain.OrderDomain;
import com.mini.order.dto.OrderDetailDTO;
import com.mini.order.dto.ParcelDTO;
import com.mini.order.dto.ShipmentDTO;
import com.mini.order.dto.request.CreateOrderRequest;
import com.mini.order.gateway.ShipmentGateway;
import com.mini.order.mapper.AddressDomainMapper;
import com.mini.order.mapper.ItemLineDomainMapper;
import com.mini.order.mapper.OrderDomainMapper;
import com.mini.order.repository.OrderDomainRepository;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;

@Service
public class DefaultOrderService implements OrderService {

	private final OrderDomainRepository orderRepository;
	private final ParcelDataLoader parcelDataLoader;
	private final ItemLineDataLoader itemLineLoader;
	private final ShipmentGateway shipmentGateway;
	private final OrderDomainMapper orderDomainMapper;
	private final ItemLineDomainMapper itemLineDomainMapper;
	private final AddressDomainMapper addressMapper;

	public DefaultOrderService(OrderDomainRepository orderRepository, ParcelDataLoader parcelDataLoader,
			ItemLineDataLoader itemLineLoader,
			ShipmentGateway shipmentGateway,
			OrderDomainMapper orderDomainMapper,
			ItemLineDomainMapper itemLineDomainMapper,
			AddressDomainMapper addressMapper) {
		this.orderRepository = orderRepository;
		this.parcelDataLoader = parcelDataLoader;
		this.itemLineLoader = itemLineLoader;
		this.shipmentGateway = shipmentGateway;
		this.orderDomainMapper = orderDomainMapper;
		this.itemLineDomainMapper = itemLineDomainMapper;
		this.addressMapper = addressMapper;
	}

	@Override
	public OrderDetailDTO getOrderDetails(Long id) throws EntityNotfoundException {
		OrderDomain order = getOrder(id);
		List<ItemLineDomain> itemLines = itemLineLoader.loadAsList(List.of(id));

		Long shipmentId = order.getShipmentId();
		
		List<ParcelDTO> parcels = null;
		ShipmentDTO shipment = null;
		if  (shipmentId != null) {
			parcels = parcelDataLoader.loadAsList(List.of(shipmentId));
			shipment = shipmentGateway.getShipment(shipmentId);
		}
		
		return orderDomainMapper.mapToOrderDetailDTO(order, itemLines,shipment, parcels);
	}

	private OrderDomain getOrder(Long id) throws EntityNotfoundException {
		OrderDomain order = orderRepository.findById(id)
				.orElseThrow(() -> new EntityNotfoundException("No order exists with ID " + id));
		return order;
	}

	@Override
	public OrderDetailDTO createOrder(CreateOrderRequest request) throws ResourceStateConflictException {
		if (orderRepository.existsByExternalOrderNumber(request.externalOrderNumber())) {
			throw new ResourceStateConflictException("Duplicate external order number");
		}
		AddressDomain address = addressMapper.toDomain(request.address());
		List<ItemLineDomain> items = request.items().stream().map(itemLineDomainMapper::mapToItemLineDO).toList();
		OrderDomain order = orderDomainMapper.mapToOrderDO(request, address, items);
		return orderDomainMapper.mapToOrderDetailDTO(orderRepository.save(order), items, null, null);
	}

//	@Override
//	public ShipmentDTO createShipment(Long orderId, CreateShipmentRequest request) throws EntityNotfoundException, ResourceStateConflictException {
//		Order order = getOrder(orderId);
//		Shipment shipment = order.createShipment(request);
//		order.setShipment(shipment);
//		return ShipmentMapper.mapToShipmentDTO(orderRepository.save(order).getShipment());
//	}

}
