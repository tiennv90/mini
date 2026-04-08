package com.mini.shipment.infrastructure.entity;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import shipping.mini.kernal.dto.entity.BaseEntity;

@Entity
@Table(name = "shipments")
public class ShipmentEntity extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ShipmentStatus shipmentStatus = ShipmentStatus.CREATED;
	
	@Column(nullable = false)
	private Long orderId;
	
	@Column
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private ZonedDateTime shippedAt;
	
	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}
	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public ZonedDateTime getShippedAt() {
		return shippedAt;
	}
	public void setShippedAt(ZonedDateTime shippedAt) {
		this.shippedAt = shippedAt;
	}
}
