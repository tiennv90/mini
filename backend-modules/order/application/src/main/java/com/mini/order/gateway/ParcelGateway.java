package com.mini.order.gateway;

import java.util.List;

import com.mini.order.dto.ParcelDTO;

public interface ParcelGateway {
	List<ParcelDTO> getParcelsByShipmentIds(List<Long> shipmentIds);

	List<ParcelDTO> getParcelsByShipmentId(Long id);
}
