package com.mini.shipment.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.infrastructure.entity.ShipmentEntity;

@Mapper(componentModel = "spring")
public interface ShipmentEntityMapper {

	ShipmentDomain toDomain(ShipmentEntity entity);
	ShipmentEntity toEntity(ShipmentDomain domain);
}
