package shipping.mini.service.shipment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import shipping.mini.domain.Shipment;
import shipping.mini.dto.ShipmentDTO;
import shipping.mini.dto.ShipmentSearchCriteria;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;

public interface ShipmentService {

	public Shipment getShipMenDetails(Long id) throws EntityNotfoundException;
	
	public Page<ShipmentDTO> getShipments(ShipmentSearchCriteria searchCriteria, Pageable pageable);

	public ShipmentDTO pack(Long id) throws EntityNotfoundException, ResourceStateConflictException;

	public ShipmentDTO ship(Long id) throws EntityNotfoundException, ResourceStateConflictException;
	
}
