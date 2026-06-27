package com.mini.shipment.command;

import com.mini.shipment.domain.ShipmentStatus;

public record ShipmentStatusChangeCommand(
        String eventId,
        Long orderId,
        Long shipmentId,
        ShipmentStatus shipmentStatus) {
}
