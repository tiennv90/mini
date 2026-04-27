package com.mini.shipment.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mini.shipment.command.ShipmentCreatedCommand;
import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.ShipmentStatus;
import com.mini.shipment.dto.ParcelDTO;
import com.mini.shipment.dto.ShipmentDTO;

@Component
public class ShipmentDomainMapper {

	public ShipmentDTO toDTO(ShipmentDomain domain) {
		return new ShipmentDTO(domain.getId(), 
				domain.getShipmentStatus(), domain.getShippedAt(), null, domain.getOrderId());
	}
	
	public ShipmentDTO toDTO(ShipmentDomain domain, List<ParcelDTO> parcels) {
		return new ShipmentDTO(domain.getId(), 
				domain.getShipmentStatus(), domain.getShippedAt(), parcels, domain.getOrderId());
	}
	
	public ShipmentDomain toDomain(ShipmentDTO dto) {
		ShipmentDomain domain = new ShipmentDomain();
		domain.setId(dto.id());
		domain.setOrderId(dto.orderId());
		domain.setShipmentStatus(dto.status());
		domain.setShippedAt(dto.shippedAt());
		return domain;
	}

	public ShipmentDomain toDomain(ShipmentCreatedCommand command) {
		ShipmentDomain domain = new ShipmentDomain();
		domain.setOrderId(command.orderId());
		domain.setShipmentStatus(ShipmentStatus.CREATED);
		domain.setShippedAt(command.shippedAt());
		return domain;
	}
}
