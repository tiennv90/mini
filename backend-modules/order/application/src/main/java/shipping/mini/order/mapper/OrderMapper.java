package shipping.mini.order.mapper;


import static shipping.mini.order.mapper.AddressMapper.*;

import java.util.List;

import shipping.mini.order.domain.Address;
import shipping.mini.order.domain.ItemLine;
import shipping.mini.order.domain.Order;
import shipping.mini.order.dto.OrderDetailDTO;
import shipping.mini.order.dto.ParcelDTO;
import shipping.mini.order.dto.ShipmentDTO;
import shipping.mini.order.dto.request.CreateOrderRequest;

public class OrderMapper {

	public static OrderDetailDTO mapToOrderDetailDTO(Order order, List<ItemLine> itemLines, ShipmentDTO shipment, List<ParcelDTO> parcels) {
		return new OrderDetailDTO(order.getId(), order.getExternalOrderNumber(), order.getOrderStatus(),
				mapToAddressDTO(order.getDeliveryAddress()),
				itemLines.stream().map(ItemLineMapper::mapToItemLineDTO).toList(),
				ShipmentMapper.mapToShipmentDTO(shipment, parcels));
	}
	
	public static Order mapToOrderDO(CreateOrderRequest request, Address address, List<ItemLine> items) {
		return new Order(request.externalOrderNumber(), address, items);
	}
}
