package com.mini.order.infrastructure.mapper;

import com.mini.order.command.ShipmentStatusChangeCommand;
import com.mini.order.domain.OrderStatusDomain;
import com.mini.order.domain.OrderTrackingViewDomain;
import com.mini.order.infrastructure.entity.OrderTrackingViewEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderTrackingViewEntityMapper {

    public OrderTrackingViewEntity toOrderTrackingViewEntity(ShipmentStatusChangeCommand shipmentStatusChangeCommand) {
        OrderTrackingViewEntity orderTrackingViewEntity = new OrderTrackingViewEntity();
        orderTrackingViewEntity.setOrderId(shipmentStatusChangeCommand.orderId());
        orderTrackingViewEntity.setOrderStatus(OrderStatusDomain.valueOf(shipmentStatusChangeCommand.shipmentStatus().name()));
        orderTrackingViewEntity.setEventId(shipmentStatusChangeCommand.eventId());
        return orderTrackingViewEntity;
    }

    public OrderTrackingViewDomain toDomain(OrderTrackingViewEntity orderTrackingViewEntity) {
        OrderTrackingViewDomain domain  = new OrderTrackingViewDomain();
        domain.setOrderId(orderTrackingViewEntity.getOrderId());
        domain.setEventId(orderTrackingViewEntity.getEventId());
        domain.setOrderStatus(orderTrackingViewEntity.getOrderStatus());
        domain.setId(orderTrackingViewEntity.getId());
        return domain;
    }
}
