package com.mini.order.infrastructure.entity;

public enum OrderStatus {
	CREATED,
	PENDING,
	PROCESSING,
	PACKED,
	SHIPPED,
	IN_TRANSIT,
	OUT_FOR_DELIVERY,
	DELIVERED,
	FAILED_DELIVERY,
	RETURNED,
	CANCELLED
}
