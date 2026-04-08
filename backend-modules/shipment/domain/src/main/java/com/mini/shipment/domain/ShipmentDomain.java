package com.mini.shipment.domain;

import java.time.ZonedDateTime;

public class ShipmentDomain {

	private Long id;
	private ShipmentStatus shipmentStatus;
	private ZonedDateTime shippedAt;
	private Long orderId;

	public ShipmentDomain() {
		super();
	}

	public ZonedDateTime getShippedAt() {
		return shippedAt;
	}

	public void setShippedAt(ZonedDateTime shippedAt) {
		this.shippedAt = shippedAt;
	}

	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
