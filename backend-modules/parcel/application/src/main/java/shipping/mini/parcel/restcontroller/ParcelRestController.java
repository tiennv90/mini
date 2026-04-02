package shipping.mini.parcel.restcontroller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;
import shipping.mini.parcel.dto.ParcelDTO;
import shipping.mini.parcel.dto.request.AssignTrackingRequest;
import shipping.mini.parcel.service.ParcelService;

@RestController
@RequestMapping("/v1/parcels")
public class ParcelRestController {
	
	private final ParcelService parcelService;
	
	public ParcelRestController(ParcelService parcelService) {
		this.parcelService = parcelService;
	}
	
	@PatchMapping("/{id}/tracking")
	public ParcelDTO parcelassignTracking(@PathVariable Long id, @RequestBody AssignTrackingRequest req) throws EntityNotfoundException, ResourceStateConflictException {
		return parcelService.assignTracking(id, req);
	}
}
