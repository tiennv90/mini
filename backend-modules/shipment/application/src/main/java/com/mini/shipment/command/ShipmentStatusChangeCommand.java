package com.mini.shipment.event;

import com.mini.shipment.domain.ShipmentStatus;

public record ShipmentStatusChangeEvent(String eventId, Long orderId, Long shipmentId, ShipmentStatus shipmentStatus) {
}
