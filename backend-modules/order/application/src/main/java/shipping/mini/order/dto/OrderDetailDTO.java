package shipping.mini.order.dto;

import java.util.List;

import shipping.mini.order.domain.OrderStatus;

public record OrderDetailDTO(Long id, String externalOrderNumber, OrderStatus orderStatus, AddressDTO deliveryAddress,
		List<ItemLineDTO> itemLines, ShipmentDTO shipment) {
}
