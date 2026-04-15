package com.mini.order.infrastructure.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mini.order.dto.ParcelDTO;

@FeignClient(name = "parcel-rest-client", url = "http://localhost:8081/v1")
public interface ParcelRestClient {
	
	@GetMapping("/parcels")
	List<ParcelDTO> getParcelsByShipmentIds(@RequestParam("shipmentIds") List<Long> shipmentIds);
}
