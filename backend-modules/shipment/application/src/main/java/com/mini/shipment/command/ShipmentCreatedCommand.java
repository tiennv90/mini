package com.mini.shipment.command;

import java.time.ZonedDateTime;


public record ShipmentCreatedCommand(Long orderId, ZonedDateTime shippedAt) {
}
