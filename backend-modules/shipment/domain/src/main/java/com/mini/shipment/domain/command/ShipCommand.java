package com.mini.shipment.domain.command;

import java.time.ZonedDateTime;

import com.mini.shipment.domain.exception.ShipmentStatusConflictException;
import org.springframework.stereotype.Component;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.ShipmentStatus;

@Component
public class ShipCommand implements ShipmentCommand {

	private final ParcelChecker parcelChecker;
	
	public ShipCommand(ParcelChecker parcelChecker) {
		this.parcelChecker = parcelChecker;
	}
	
	@Override
	public void execute(ShipmentDomain shipment) throws ShipmentStatusConflictException {
		
		if (!shipment.getShipmentStatus().equals(ShipmentStatus.PACKED)) {
			throw new ShipmentStatusConflictException("Shipment state is not ready to be shipped");
		}
		boolean allTracked = parcelChecker.allParcelsTracked(shipment);
		if (!allTracked) {
			throw new ShipmentStatusConflictException("All parcels must have tracking code");
		}
		shipment.setShipmentStatus(ShipmentStatus.SHIPPED);
		shipment.setShippedAt(ZonedDateTime.now());
	}

	@Override
	public ShipmentStatus getTargetStatus() {
		return ShipmentStatus.SHIPPED;
	}

}
