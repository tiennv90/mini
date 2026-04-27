package com.mini.order.mapper;

import org.springframework.stereotype.Component;

import com.mini.order.domain.AddressDomain;
import com.mini.order.dto.AddressDTO;

@Component
public class AddressDomainMapper {

	public AddressDomain toDomain(AddressDTO dto) {
		AddressDomain domain = new AddressDomain();
		domain.setCity(dto.city());
		domain.setCountry(dto.city());
		domain.setHouseNumber(dto.houseNumber());
		domain.setPostalCode(dto.postalCode());
		domain.setStreet(dto.street());
		return domain;
	}
	
	public AddressDTO toDTO(AddressDomain domain) {
		return new AddressDTO(domain.getStreet(), domain.getHouseNumber(), 
				domain.getCity(), domain.getPostalCode(), domain.getCountry());
	}
}
