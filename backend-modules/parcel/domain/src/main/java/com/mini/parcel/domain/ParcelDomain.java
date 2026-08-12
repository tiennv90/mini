package com.mini.parcel.domain;

import com.mini.parcel.exception.ParcelStatusConflictException;

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
	
	public void assignTracking(String trackingCode) throws ParcelStatusConflictException {
		if (this.trackingCode != null) {
			throw new ParcelStatusConflictException("Tracking code already assigned");
		}
		this.trackingCode = trackingCode;
	}

	public boolean hasTracking() {
		return trackingCode != null;
	}	
}
