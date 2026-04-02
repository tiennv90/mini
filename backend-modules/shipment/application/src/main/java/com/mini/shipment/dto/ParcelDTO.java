package com.mini.shipment.dto;

public record ParcelDTO(
		Long id,
		String carrier,
		String trackingCode
		) {}
