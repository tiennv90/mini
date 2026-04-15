package com.mini.order.mapper;

import org.springframework.stereotype.Component;

import com.mini.order.domain.ItemLineDomain;
import com.mini.order.dto.ItemLineDTO;

@Component
public class ItemLineDomainMapper {

	public ItemLineDomain mapToItemLineDO(ItemLineDTO itemLineDTO) {
		ItemLineDomain domain = new ItemLineDomain();
		domain.setOrderId(itemLineDTO.orderId());
		domain.setProductName(itemLineDTO.productName());
		domain.setQuantity(itemLineDTO.quantity());
		return domain;
	}
	
	public ItemLineDTO toDTO(ItemLineDomain domain) {
		return new ItemLineDTO(domain.getOrderId(), domain.getProductName(), domain.getQuantity());
	}
}
