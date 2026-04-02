package com.mini.shipment.dto;

import java.time.ZonedDateTime;
import java.util.List;

import com.mini.shipment.domain.ShipmentStatus;

public record ShipmentDTO(
		Long id, 
		ShipmentStatus status,
		ZonedDateTime shippedAt, 
		List<ParcelDTO> parcels) {
}
