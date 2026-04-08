package com.mini.shipment.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.dto.ParcelDTO;
import com.mini.shipment.dto.ShipmentDTO;

@Mapper(componentModel = "spring")
public interface ShipmentDomainMapper {

	ShipmentDTO toDTO(ShipmentDomain domain);
	
	@Mapping(target = "parcels", source = "parcels")
	ShipmentDTO toDTO(ShipmentDomain domain, List<ParcelDTO> parcels);
	
	ShipmentDomain toDomain(ShipmentDTO dto);
}
