package com.mini.order.command;


import com.mini.order.domain.ShipmentTrackingStatusDomain;

public record ShipmentStatusChangeCommand(
        String eventId,
        Long orderId,
        Long shipmentId,
        ShipmentTrackingStatusDomain shipmentStatus) {
}
