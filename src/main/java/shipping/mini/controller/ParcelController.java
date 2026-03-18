package shipping.mini.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shipping.mini.dto.ParcelDTO;
import shipping.mini.dto.request.AssignTrackingRequest;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;
import shipping.mini.service.parcel.ParcelService;

@RestController
@RequestMapping("/v1/parcels")
public class ParcelController {
	private final ParcelService parcelService;
	
	public ParcelController(ParcelService parcelService) {
		this.parcelService = parcelService;
	}
	
	@PostMapping("/{id}/tracking")
	public ParcelDTO parcelassignTracking(@PathVariable Long id, @RequestBody AssignTrackingRequest req) throws EntityNotfoundException, ResourceStateConflictException {
		return parcelService.assignTracking(id, req);
	}
}
