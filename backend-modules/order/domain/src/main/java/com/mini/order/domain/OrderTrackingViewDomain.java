package com.mini.order.domain;

public class OrderTrackingViewDomain {
    private Long id;
    private Long orderId;
    private OrderStatusDomain orderStatus;
    private String eventId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatusDomain getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusDomain orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
