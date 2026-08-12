package com.mini.shipment.domain.command;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.ShipmentStatus;

import com.mini.shipment.domain.exception.ShipmentStatusConflictException;

public interface ShipmentCommand {
	ShipmentStatus getTargetStatus();
	void execute(ShipmentDomain shipment) throws ShipmentStatusConflictException;
}
