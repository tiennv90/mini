package com.mini.order.infrastructure.gateway.impl;

import org.springframework.stereotype.Component;

import com.mini.order.dto.ShipmentDTO;
import com.mini.order.gateway.ShipmentGateway;
import com.mini.order.infrastructure.restclient.ShipmentRestClient;

@Component
public class ShipmentGatewayImpl implements ShipmentGateway {

	private final ShipmentRestClient shipmentRestClient;
	
	public ShipmentGatewayImpl(ShipmentRestClient shipmentRestClient) {
		this.shipmentRestClient = shipmentRestClient;
	}
	
	@Override
	public ShipmentDTO getShipment(Long shipmentId) {
		return shipmentRestClient.getShipment(shipmentId);
	}

}
