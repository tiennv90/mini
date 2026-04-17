package com.mini.parcel.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.mini.parcel.domain.ParcelDomain;
import com.mini.parcel.infrastructure.entity.ParcelEntity;

@Component
public class ParcelEntityMapper {

	public ParcelDomain toDomain(ParcelEntity parcelEntity) {
		ParcelDomain domain = new ParcelDomain();
		domain.setId(parcelEntity.getId());
		domain.setCarrier(parcelEntity.getCarrier());
		domain.setShipmentId(parcelEntity.getShipmentId());
		return domain;
	}
	
	public ParcelEntity toEntity(ParcelDomain parcelDomain) {
		ParcelEntity entity = new ParcelEntity();
		entity.setId(parcelDomain.getId());
		entity.setCarrier(parcelDomain.getCarrier());
		entity.setShipmentId(parcelDomain.getShipmentId());
		return entity;
	}
}
