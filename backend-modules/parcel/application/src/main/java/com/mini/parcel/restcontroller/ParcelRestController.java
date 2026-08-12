package com.mini.parcel.restcontroller;

import java.util.List;

import com.mini.parcel.exception.ParcelNotFoundException;
import com.mini.parcel.exception.ParcelStatusConflictException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mini.parcel.dto.ParcelDTO;
import com.mini.parcel.dto.request.AssignTrackingRequest;
import com.mini.parcel.service.ParcelService;


@RestController
@RequestMapping("/v1/parcels")
public class ParcelRestController {
	
	private final ParcelService parcelService;
	
	public ParcelRestController(ParcelService parcelService) {
		this.parcelService = parcelService;
	}
	
	@GetMapping("/shipment/{shipmentId}")
	public List<ParcelDTO> getParcelsByShipmentId(@PathVariable Long shipmentId) {
		return parcelService.getParcelsByShipmentId(shipmentId);
	}
	
	@PatchMapping("/{id}/tracking")
	public ParcelDTO parcelAssignTracking(@PathVariable Long id, @RequestBody AssignTrackingRequest req) throws ParcelNotFoundException, ParcelStatusConflictException {
		return parcelService.assignTracking(id, req);
	}
}
