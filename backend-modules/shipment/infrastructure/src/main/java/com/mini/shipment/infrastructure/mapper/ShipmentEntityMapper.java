package com.mini.shipment.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.ShipmentStatus;
import com.mini.shipment.infrastructure.entity.ShipmentEntity;

@Component
public class ShipmentEntityMapper {

	public ShipmentDomain toDomain(ShipmentEntity entity) {
		ShipmentDomain domain = new ShipmentDomain();
		domain.setId(entity.getId());
		domain.setOrderId(entity.getOrderId());
		if (entity.getShipmentStatus() != null) {
			domain.setShipmentStatus(ShipmentStatus.valueOf(entity.getShipmentStatus().name()));
		}
		domain.setShippedAt(entity.getShippedAt());
		return domain;
	}
	
	public ShipmentEntity toEntity(ShipmentDomain domain) {
		ShipmentEntity entity = new ShipmentEntity();
		entity.setId(domain.getId());
		entity.setOrderId(domain.getOrderId());
		if (domain.getShipmentStatus() != null) {
			entity.setShipmentStatus(com.mini.shipment.infrastructure.entity.ShipmentStatus.valueOf(domain.getShipmentStatus().name()));
		}
		return entity;
	}
}
