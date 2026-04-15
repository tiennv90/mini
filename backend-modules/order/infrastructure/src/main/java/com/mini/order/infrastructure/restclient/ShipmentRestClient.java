package com.mini.order.infrastructure.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mini.order.dto.ShipmentDTO;

@FeignClient(name = "shipment-rest-client", url = "http://localhost:8082/v1")
public interface ShipmentRestClient {

	@GetMapping("/shipment/{shipmentId}")
	public ShipmentDTO getShipment(@PathVariable Long shipmentId);
}
