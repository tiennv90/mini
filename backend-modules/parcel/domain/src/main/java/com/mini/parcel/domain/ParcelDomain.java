package com.mini.parcel.domain;

import shipping.mini.kernal.exception.ResourceStateConflictException;

public class ParcelDomain {
	
	private Long id;
	private String trackingCode;
	private String carrier;
	private Long shipmentId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public void assignTracking(String trackingCode) throws ResourceStateConflictException {
		if (this.trackingCode != null) {
			throw new ResourceStateConflictException("Tracking code already assigned");
		}
		this.trackingCode = trackingCode;
	}

	public boolean hasTracking() {
		return trackingCode != null;
	}	
}
