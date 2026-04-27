package com.mini.order.infrastructure.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mini.order.command.ShipmentCreatedCommand;
import com.mini.order.publisher.ShipmentEventPublisher;

@Service
public class ShipmentEventKafkaProducerImpl implements ShipmentEventPublisher {

	private static final Logger logger = LoggerFactory.getLogger(ShipmentEventKafkaProducerImpl.class);
	
	private final KafkaTemplate<String, Object> kafkatemplate;
	
    public ShipmentEventKafkaProducerImpl(KafkaTemplate<String, Object> kafkatemplate) {
    	this.kafkatemplate = kafkatemplate;
    }

	@Override
	public void publishCreatedShipmentEvent(ShipmentCreatedCommand command) {
    	logger.info("Send to shipment.created topic");
    	kafkatemplate.send("shipment.created", command);
	}
}
