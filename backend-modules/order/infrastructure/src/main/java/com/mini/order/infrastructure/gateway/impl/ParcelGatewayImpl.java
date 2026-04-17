package com.mini.order.infrastructure.gateway.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mini.order.dto.ParcelDTO;
import com.mini.order.gateway.ParcelGateway;
import com.mini.order.infrastructure.restclient.ParcelRestClient;

@Component
public class ParcelGatewayImpl implements ParcelGateway {

	private final ParcelRestClient parcelRestClient;
	
	public ParcelGatewayImpl(ParcelRestClient parcelRestClient) {
		this.parcelRestClient = parcelRestClient;
	}
	@Override
	public List<ParcelDTO> getParcelsByShipmentIds(List<Long> shipmentIds) {
		return parcelRestClient.getParcelsByShipmentIds(shipmentIds);
	}
	@Override
	public List<ParcelDTO> getParcelsByShipmentId(Long shipmentId) {
		return parcelRestClient.getParcelsByShipmentId(shipmentId);
	}

}
