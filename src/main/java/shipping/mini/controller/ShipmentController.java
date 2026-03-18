package shipping.mini.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shipping.mini.controller.mapper.ShipmentMapper;
import shipping.mini.dto.ShipmentDTO;
import shipping.mini.dto.ShipmentSearchCriteria;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;
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
	
	@PostMapping("/{id}/pack")
	public ShipmentDTO pack(@PathVariable Long id) throws EntityNotfoundException, ResourceStateConflictException {
		return shipmentService.pack(id);
	}
	
	@PostMapping("/{id}/ship")
	public ShipmentDTO ship(@PathVariable Long id) throws EntityNotfoundException, ResourceStateConflictException {
		return shipmentService.ship(id);
	}
	

	@GetMapping
	public Page<ShipmentDTO> searchShipments(ShipmentSearchCriteria criteria,
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "10") int size) {
		
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
		return shipmentService.getShipments(criteria, pageable);
	}
}
