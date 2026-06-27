package com.mini.shipment.infrastructure.kafka.producer;

import com.mini.shipment.command.ShipmentStatusChangeCommand;
import com.mini.shipment.service.ShipmentNotificationService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ShipmentNotificationServiceImpl implements ShipmentNotificationService {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public ShipmentNotificationServiceImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Async
    public void sendNotification(ShipmentStatusChangeCommand command) {
        kafkaTemplate.send("shipment.view", command);
    }
}
