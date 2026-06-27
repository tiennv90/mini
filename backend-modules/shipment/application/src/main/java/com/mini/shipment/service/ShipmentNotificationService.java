package com.mini.shipment.service;


import com.mini.shipment.command.ShipmentStatusChangeCommand;

public interface ShipmentNotificationService {
    void sendNotification(ShipmentStatusChangeCommand command);
}
