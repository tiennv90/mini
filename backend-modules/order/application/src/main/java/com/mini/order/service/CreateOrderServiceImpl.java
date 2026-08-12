package com.mini.order.service;

import java.util.List;

import com.mini.order.exception.OrderStatusConflictException;
import org.springframework.stereotype.Service;

import com.mini.order.domain.AddressDomain;
import com.mini.order.domain.ItemLineDomain;
import com.mini.order.domain.OrderDomain;
import com.mini.order.dto.OrderDetailDTO;
import com.mini.order.dto.request.CreateOrderRequest;
import com.mini.order.mapper.AddressDomainMapper;
import com.mini.order.mapper.ItemLineDomainMapper;
import com.mini.order.mapper.OrderDomainMapper;
import com.mini.order.publisher.ShipmentEventPublisher;
import com.mini.order.repository.OrderDomainRepository;


@Service
public class CreateOrderServiceImpl implements CreateOrderService {

	private final OrderDomainRepository orderRepository;
	private final OrderDomainMapper orderDomainMapper;
	private final ItemLineDomainMapper itemLineDomainMapper;
	private final AddressDomainMapper addressMapper;
	private final ShipmentEventPublisher shipmentEventGateway;

	public CreateOrderServiceImpl(OrderDomainRepository orderRepository,
			OrderDomainMapper orderDomainMapper,
			ItemLineDomainMapper itemLineDomainMapper,
			AddressDomainMapper addressMapper,
			ShipmentEventPublisher shipmentEventGateway) {
		this.orderRepository = orderRepository;
		this.orderDomainMapper = orderDomainMapper;
		this.itemLineDomainMapper = itemLineDomainMapper;
		this.addressMapper = addressMapper;
		this.shipmentEventGateway = shipmentEventGateway;
	}
	
	@Override
	public OrderDetailDTO createOrder(CreateOrderRequest request) throws OrderStatusConflictException {
		if (orderRepository.existsByExternalOrderNumber(request.externalOrderNumber())) {
			throw new OrderStatusConflictException("Duplicate external order number");
		}
		AddressDomain address = addressMapper.toDomain(request.address());
		List<ItemLineDomain> items = request.items().stream().map(itemLineDomainMapper::mapToItemLineDO).toList();
		OrderDomain order = orderDomainMapper.mapToOrderDO(request, address, items);
		order.createOrder();
		order = orderRepository.save(order);
		shipmentEventGateway.publishCreatedShipmentEvent(orderDomainMapper.toShipmentCreatedCommand(order));
		
		return orderDomainMapper.mapToOrderDTO(order, items);
	}

}
