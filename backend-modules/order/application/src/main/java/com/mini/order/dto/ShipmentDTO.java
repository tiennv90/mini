package com.mini.order.dto;

import java.util.List;

public record ShipmentDTO(
		
		Long id, 
		ShipmentStatusDTO status,
		
		String shippedAt, 
		List<ParcelDTO> parcels) {
	
}
