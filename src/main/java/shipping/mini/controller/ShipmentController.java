package shipping.mini.controller;

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

import shipping.mini.dto.ShipmentDTO;
import shipping.mini.dto.ShipmentSearchCriteria;
import shipping.mini.dto.request.ChangeShipmentRequest;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;
import shipping.mini.mapper.ShipmentMapper;
import shipping.mini.service.shipment.ShipmentService;

@RestController
@RequestMapping("/v1/shipments")
public class ShipmentController {

	private final ShipmentService shipmentService;

	public ShipmentController(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}
	
	@GetMapping("/{id}")
	public ShipmentDTO getShipmentDetails(@PathVariable Long id) throws EntityNotfoundException {
		return ShipmentMapper.mapToShipmentDTO(shipmentService.getShipMenDetails(id));
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
