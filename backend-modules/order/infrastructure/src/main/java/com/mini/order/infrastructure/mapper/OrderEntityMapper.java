package com.mini.order.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mini.order.domain.OrderDomain;
import com.mini.order.domain.OrderStatusDomain;
import com.mini.order.infrastructure.entity.ItemLineEntity;
import com.mini.order.infrastructure.entity.OrderEntity;
import com.mini.order.infrastructure.entity.OrderStatus;

@Component
public class OrderEntityMapper {
	
	private final AddressEntityMapper addressMapper;
	private final ItemLineEntityMapper itemLineMapper;
	
	public OrderEntityMapper(AddressEntityMapper addressMapper, ItemLineEntityMapper itemLineMapper) {
		this.addressMapper = addressMapper;
		this.itemLineMapper = itemLineMapper;
	}
	
	public OrderDomain toDomain(OrderEntity entity) {
		OrderDomain domain = new OrderDomain();
		domain.setDeliveryAddress(addressMapper.toDomain(entity.getDeliveryAddress()));
		domain.setExternalOrderNumber(entity.getExternalOrderNumber());
		domain.setOrderStatus(OrderStatusDomain.valueOf(entity.getOrderStatus().name()));
		domain.setShipmentId(entity.getShipmentId());
		domain.setId(entity.getId());
		return domain;
	}
	
	public OrderEntity toEntity(OrderDomain domain) {
		List<ItemLineEntity> itemlines = null;
		if (domain.getItemlines() != null) {
			itemlines = domain.getItemlines().stream().map(itemLineMapper::toEntity)
					.collect(Collectors.toList());
		}
		OrderEntity entity = new OrderEntity();
		entity.setId(domain.getId());
		entity.setDeliveryAddress(addressMapper.toEntity(domain.getDeliveryAddress()));
		entity.setExternalOrderNumber(domain.getExternalOrderNumber());
		entity.setItemlines(itemlines);
		entity.setShipmentId(domain.getShipmentId());
		entity.setOrderStatus(OrderStatus.valueOf(domain.getOrderStatus().name()));
		return entity;
	}
	
}
