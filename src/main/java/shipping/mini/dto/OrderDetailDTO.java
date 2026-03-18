package shipping.mini.dto;

import java.util.List;

import shipping.mini.domain.OrderStatus;

public record OrderDetailDTO(
		Long id, 
		String externalOrderNumber, 
		OrderStatus orderStatus, 
		AddressDTO deliveryAddress,
		List<ItemLineDTO> itemLines, 
		ShipmentDTO shipment) {
}
