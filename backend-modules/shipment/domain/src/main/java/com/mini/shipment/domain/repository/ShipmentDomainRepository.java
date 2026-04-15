package com.mini.shipment.domain.repository;

import java.util.Optional;

import com.mini.shipment.domain.ShipmentDomain;

public interface ShipmentDomainRepository {

	Optional<ShipmentDomain> findShipmentDetailsById(Long id);
	Optional<ShipmentDomain> findById(Long id);
	ShipmentDomain save(ShipmentDomain shipmentDomain);
}
