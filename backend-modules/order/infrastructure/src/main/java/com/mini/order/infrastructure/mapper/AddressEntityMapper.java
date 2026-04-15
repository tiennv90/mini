package com.mini.order.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.mini.order.domain.AddressDomain;
import com.mini.order.infrastructure.entity.AddressEntity;

@Component
public class AddressEntityMapper {

	public AddressDomain toDomain(AddressEntity entity) {
		AddressDomain domain = new AddressDomain();
		domain.setId(entity.getId());
		domain.setCity(entity.getCity());
		domain.setCountry(entity.getCountry());
		domain.setHouseNumber(entity.getHouseNumber());
		domain.setPostalCode(entity.getPostalCode());
		domain.setStreet(entity.getStreet());
		return domain;
	}
	
	public AddressEntity toEntity(AddressDomain domain) {
		AddressEntity entity = new AddressEntity();
		entity.setId(domain.getId());
		entity.setCity(domain.getCity());
		entity.setCountry(domain.getCountry());
		entity.setHouseNumber(domain.getHouseNumber());
		entity.setPostalCode(domain.getPostalCode());
		entity.setStreet(domain.getStreet());
		return entity;
	}
}
