package com.mini.shipment.gateway;

import java.util.List;

import com.mini.shipment.dto.ParcelDTO;

public interface ParcelGateway {
	List<ParcelDTO> findByShipmentIdIn(List<Long> keyIds);
}
