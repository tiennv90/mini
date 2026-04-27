package com.mini.shipment.service;

import org.springframework.stereotype.Service;

import com.mini.shipment.command.ShipmentCreatedCommand;
import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.repository.ShipmentDomainRepository;
import com.mini.shipment.dto.ShipmentDTO;
import com.mini.shipment.mapper.ShipmentDomainMapper;

@Service
public class CreateShipmentServiceImpl implements CreateShipmentService {

	private final ShipmentDomainRepository shipmentDomainRepository;
	private final ShipmentDomainMapper mapper;
	
	public CreateShipmentServiceImpl(ShipmentDomainRepository shipmentDomainRepository, ShipmentDomainMapper mapper) {
		this.shipmentDomainRepository = shipmentDomainRepository;
		this.mapper = mapper;
	}
	@Override
	public ShipmentDTO createShipment(ShipmentCreatedCommand command) {
		ShipmentDomain domain = mapper.toDomain(command);
		return mapper.toDTO(shipmentDomainRepository.save(domain));
	}

}
