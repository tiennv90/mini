package com.mini.parcel.mapper;

import org.springframework.stereotype.Component;

import com.mini.parcel.domain.ParcelDomain;
import com.mini.parcel.dto.ParcelDTO;

@Component
public class ParcelDomainMapper {

	public ParcelDTO toDTo(ParcelDomain domain) {
		return new ParcelDTO(domain.getId(), domain.getCarrier(), 
				domain.getTrackingCode(), domain.getShipmentId());
	}
	
	public ParcelDomain toDomain(ParcelDTO dto) {
		ParcelDomain domain = new ParcelDomain();
		domain.setId(dto.id());
		domain.setShipmentId(dto.shipmentId());
		domain.setTrackingCode(dto.trackingCode());
		domain.setCarrier(dto.carrier());
		return domain;
	}
}
