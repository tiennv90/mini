package com.mini.shipment.domain;

public class ParcelDomain {
	
	private final String trackingCode;

	public ParcelDomain(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public boolean hasTracking() {
		return trackingCode != null && !trackingCode.isBlank();
	}
}
