package com.mini.shipment.infrastructure.gateway.impl;

import java.util.List;

import com.mini.shipment.dto.ParcelDTO;
import com.mini.shipment.gateway.ParcelGateway;
import com.mini.shipment.infrastructure.restclient.ParcelRestClient;

public class ParcelGatewayImpl implements ParcelGateway{

	private final ParcelRestClient parcelRestClient;
	
	public ParcelGatewayImpl(ParcelRestClient parcelRestClient) {
		this.parcelRestClient = parcelRestClient;
	}
	
	@Override
	public List<ParcelDTO> findByShipmentIdIn(List<Long> keyIds) {
		return parcelRestClient.getParcelsByShipmentIds(keyIds);
	}

}
