package com.mini.shipment.service;

import com.mini.shipment.domain.exception.ShipmentNotFoundException;
import com.mini.shipment.domain.exception.ShipmentStatusConflictException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mini.shipment.dto.ShipmentDTO;
import com.mini.shipment.dto.request.ChangeShipmentRequest;
import com.mini.shipment.dto.request.ShipmentSearchCriteria;


public interface ShipmentService {
	public ShipmentDTO getShipMenDetails(Long id) throws ShipmentNotFoundException;
	
	public Page<ShipmentDTO> getShipments(ShipmentSearchCriteria searchCriteria, Pageable pageable);

	public ShipmentDTO updateStatus(Long id, ChangeShipmentRequest req) throws ShipmentNotFoundException, ShipmentStatusConflictException;

	public ShipmentDTO getShipmentByOrder(Long orderId) throws ShipmentNotFoundException;
}
