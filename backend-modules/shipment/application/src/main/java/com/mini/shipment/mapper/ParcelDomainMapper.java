package com.mini.shipment.mapper;

import org.springframework.stereotype.Component;

import com.mini.shipment.domain.ParcelDomain;
import com.mini.shipment.dto.ParcelDTO;

@Component
public class ParcelDomainMapper {
	
	public ParcelDomain toDomain(ParcelDTO parcelDTO) {
		ParcelDomain parcelDomain = new ParcelDomain(parcelDTO.trackingCode());
		return parcelDomain;
	}
	
}
