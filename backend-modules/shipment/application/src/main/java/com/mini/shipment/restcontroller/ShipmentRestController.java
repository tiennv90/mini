package com.mini.shipment.restcontroller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mini.shipment.dto.ShipmentDTO;
import com.mini.shipment.dto.request.ChangeShipmentRequest;
import com.mini.shipment.dto.request.ShipmentSearchCriteria;
import com.mini.shipment.service.ShipmentService;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;


@RestController
@RequestMapping("/v1/shipments")
public class ShipmentRestController {

	private final ShipmentService shipmentService;

	public ShipmentRestController(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}
	
	@GetMapping("/{id}")
	public ShipmentDTO getShipmentDetails(@PathVariable Long id) throws EntityNotfoundException {
		return shipmentService.getShipMenDetails(id);
	}
	
	@GetMapping("/order/{orderId}")
	public ShipmentDTO getShipmentByOrder(@PathVariable Long orderId) throws EntityNotfoundException {
		return shipmentService.getShipmentByOrder(orderId);
	}	
	
	@PatchMapping("/{id}")
	public ShipmentDTO updateStatus(@PathVariable Long id,@RequestBody ChangeShipmentRequest req) 
			throws EntityNotfoundException, ResourceStateConflictException {
		return shipmentService.updateStatus(id,req);
	}
	
	@GetMapping
	public Page<ShipmentDTO> searchShipments(ShipmentSearchCriteria criteria,
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "5") int size) {
		
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
		return shipmentService.getShipments(criteria, pageable);
	}
}
