package com.mini.parcel.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import shipping.mini.kernal.dto.entity.BaseEntity;
import shipping.mini.kernal.exception.ResourceStateConflictException;

@Entity
@Table(name = "parcels", uniqueConstraints = @UniqueConstraint(name = "uc_tracking_code", columnNames = "tracking_code"))
public class Parcel extends BaseEntity {

	@Column(name = "tracking_code", nullable = true)
	private String trackingCode;
	
	@Column(nullable = false)
	private String carrier;

	@Column(nullable = false)
	private Long shipmentId;

	public Parcel() {
		super();
	}
	
	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}	
	
	public Long getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}

}
