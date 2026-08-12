package com.mini.shipment.domain.command;

import com.mini.shipment.domain.exception.ShipmentStatusConflictException;
import org.springframework.stereotype.Component;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.ShipmentStatus;


@Component
public class PackCommand implements ShipmentCommand {

	@Override
	public void execute(ShipmentDomain shipment) throws ShipmentStatusConflictException {
		if (!shipment.getShipmentStatus().equals(ShipmentStatus.CREATED)) {
			throw new ShipmentStatusConflictException("Shipment state is not ready to be packed");
		}
		shipment.setShipmentStatus(ShipmentStatus.PACKED);
	}

	@Override
	public ShipmentStatus getTargetStatus() {
		return ShipmentStatus.PACKED;
	}

}
