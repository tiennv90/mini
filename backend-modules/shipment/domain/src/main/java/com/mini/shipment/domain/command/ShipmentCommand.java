package com.mini.shipment.domain.command;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.ShipmentStatus;

import shipping.mini.kernal.exception.ResourceStateConflictException;

public interface ShipmentCommand {
	ShipmentStatus getTargetStatus();
	void execute(ShipmentDomain shipment) throws ResourceStateConflictException;
}
