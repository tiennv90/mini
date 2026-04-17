package com.mini.order.gateway;

import com.mini.order.dto.ShipmentDTO;

public interface ShipmentGateway {
	public ShipmentDTO getShipment(Long shipmentId);

	public ShipmentDTO getShipmentByOrderId(Long orderId);
}
