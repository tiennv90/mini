package com.mini.order.infrastructure.entity;

import com.mini.order.domain.OrderStatusDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import shipping.mini.kernal.dto.entity.BaseEntity;

@Entity
@Table(name = "order_tracking_view")
public class OrderTrackingViewEntity extends BaseEntity {

    private Long orderId;
    private OrderStatusDomain orderStatus;
    private String eventId;

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatus(OrderStatusDomain orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderStatusDomain getOrderStatus() {
        return orderStatus;
    }

    public String getEventId() {
        return eventId;
    }
}
