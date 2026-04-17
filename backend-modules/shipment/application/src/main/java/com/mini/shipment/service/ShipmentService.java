package com.mini.shipment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mini.shipment.dto.ShipmentDTO;
import com.mini.shipment.dto.request.ChangeShipmentRequest;
import com.mini.shipment.dto.request.ShipmentSearchCriteria;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;


public interface ShipmentService {
	public ShipmentDTO getShipMenDetails(Long id) throws EntityNotfoundException;
	
	public Page<ShipmentDTO> getShipments(ShipmentSearchCriteria searchCriteria, Pageable pageable);

	public ShipmentDTO updateStatus(Long id, ChangeShipmentRequest req) throws EntityNotfoundException, ResourceStateConflictException;

	public ShipmentDTO getShipmentByOrder(Long orderId) throws EntityNotfoundException;
}
