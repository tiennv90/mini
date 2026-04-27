package com.mini.shipment.service;

import com.mini.shipment.command.ShipmentCreatedCommand;
import com.mini.shipment.dto.ShipmentDTO;

public interface CreateShipmentService {

	public ShipmentDTO createShipment(ShipmentCreatedCommand command);
}
