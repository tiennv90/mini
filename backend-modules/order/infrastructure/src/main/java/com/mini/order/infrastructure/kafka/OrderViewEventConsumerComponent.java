package com.mini.order.infrastructure.kafka;

import com.mini.order.command.ShipmentStatusChangeCommand;
import com.mini.order.infrastructure.jparepository.OrderTrackingViewJpaRepository;
import com.mini.order.infrastructure.mapper.OrderTrackingViewEntityMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderViewEventConsumerComponent {

    private final OrderTrackingViewJpaRepository orderTrackingViewJpaRepository;
    private final OrderTrackingViewEntityMapper mapper;

    public OrderViewEventConsumerComponent(
            OrderTrackingViewJpaRepository orderTrackingViewJpaRepository,
            OrderTrackingViewEntityMapper mapper) {
        this.orderTrackingViewJpaRepository = orderTrackingViewJpaRepository;
        this.mapper = mapper;
    }

    @KafkaListener(topics = "shipment.view", groupId = "order-group-id")
    public void consumeEvent(@Payload ShipmentStatusChangeCommand command) {
        orderTrackingViewJpaRepository.save(mapper.toOrderTrackingViewEntity(command));
    }
}
