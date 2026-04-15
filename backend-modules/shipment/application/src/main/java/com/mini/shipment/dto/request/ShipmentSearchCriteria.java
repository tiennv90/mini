package com.mini.shipment.dto.request;

import com.mini.shipment.domain.ShipmentStatus;

public record ShipmentSearchCriteria(
	String carrier, 
	ShipmentStatus status) {
}
