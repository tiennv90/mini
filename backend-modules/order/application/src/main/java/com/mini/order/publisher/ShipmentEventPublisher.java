package com.mini.order.publisher;

import com.mini.order.command.ShipmentCreatedCommand;

public interface ShipmentEventPublisher {
	
	public void publishCreatedShipmentEvent(ShipmentCreatedCommand command);

}
