package com.mini.shipment.domain.command;

import org.springframework.stereotype.Component;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.ShipmentStatus;

import shipping.mini.kernal.exception.ResourceStateConflictException;


@Component
public class PackCommand implements ShipmentCommand {

	@Override
	public void execute(ShipmentDomain shipment) throws ResourceStateConflictException {
		if (!shipment.getShipmentStatus().equals(ShipmentStatus.CREATED)) {
			throw new ResourceStateConflictException("Shipment state is not ready to be packed");
		}
		shipment.setShipmentStatus(ShipmentStatus.PACKED);
	}

	@Override
	public ShipmentStatus getTargetStatus() {
		return ShipmentStatus.PACKED;
	}

}
