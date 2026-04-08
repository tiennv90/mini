package com.mini.order.dto;

import java.util.List;

import com.mini.order.domain.OrderStatusDomain;


public record OrderDetailDTO(Long id, String externalOrderNumber, OrderStatusDomain orderStatus, AddressDTO deliveryAddress,
		List<ItemLineDTO> itemLines, ShipmentDTO shipment, List<ParcelDTO> parcels) {
}
