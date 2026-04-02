package com.mini.shipment.domain;

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
public class Shipment extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ShipmentStatus shipmentStatus = ShipmentStatus.CREATED;

	@Column
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private ZonedDateTime shippedAt;

    @Column(nullable = false)
    private Long orderId;

	public Shipment() {
		super();
	}

	public Shipment(Long id) {
		setId(id);
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
	
}
