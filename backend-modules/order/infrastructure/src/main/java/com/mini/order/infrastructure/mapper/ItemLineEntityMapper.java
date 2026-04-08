package com.mini.order.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.mini.order.domain.ItemLineDomain;
import com.mini.order.infrastructure.entity.ItemLineEntity;

@Component
public class ItemLineEntityMapper {
	
	public ItemLineDomain toDomain(ItemLineEntity entity) {
		ItemLineDomain domain = new ItemLineDomain();
		domain.setOrderId(entity.getOrder().getId());
		domain.setProductName(entity.getProductName());
		domain.setQuantity(entity.getQuantity());
		return domain;
	}
	
	public ItemLineEntity toEntity(ItemLineDomain domain) {
		return new ItemLineEntity(domain.getProductName(), domain.getQuantity());
	}
}
