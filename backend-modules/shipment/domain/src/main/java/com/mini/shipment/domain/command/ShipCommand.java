package com.mini.shipment.domain.command;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.ShipmentStatus;

import shipping.mini.kernal.exception.ResourceStateConflictException;

@Component
public class ShipCommand implements ShipmentCommand {

	private final ParcelChecker parcelChecker;
	
	public ShipCommand(ParcelChecker parcelChecker) {
		this.parcelChecker = parcelChecker;
	}
	
	@Override
	public void execute(ShipmentDomain shipment) throws ResourceStateConflictException {
		
		if (!shipment.getShipmentStatus().equals(ShipmentStatus.PACKED)) {
			throw new ResourceStateConflictException("Shipment state is not ready to be shipped");
		}
		boolean allTracked = parcelChecker.allParcelsTracked(shipment);
		if (!allTracked) {
			throw new ResourceStateConflictException("All parcels must have tracking code");
		}
		shipment.setShipmentStatus(ShipmentStatus.SHIPPED);
		shipment.setShippedAt(ZonedDateTime.now());
	}

	@Override
	public ShipmentStatus getTargetStatus() {
		return ShipmentStatus.SHIPPED;
	}

}
