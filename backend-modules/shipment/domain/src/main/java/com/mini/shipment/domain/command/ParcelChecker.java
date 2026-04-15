package com.mini.shipment.domain.command;

import com.mini.shipment.domain.ShipmentDomain;

public interface ParcelChecker {
	boolean allParcelsTracked(ShipmentDomain shipment);
}
