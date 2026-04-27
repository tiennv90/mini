package com.mini.shipment.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.mini.shipment.command.ShipmentCreatedCommand;
import com.mini.shipment.service.CreateShipmentService;

@Component
public class ShipmentEventConsumerComponent {

	private final CreateShipmentService createShipmentService;
	
	public ShipmentEventConsumerComponent(CreateShipmentService createShipmentService) {
		this.createShipmentService = createShipmentService;
	}
	
	@KafkaListener(topics =  "shipment.created", groupId = "shipment-service")
	public void consumeEvent(@Payload ShipmentCreatedCommand command) {
		createShipmentService.createShipment(command);
	}

}
