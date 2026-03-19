package shipping.mini.mapper;

import shipping.mini.domain.Address;
import shipping.mini.domain.ItemLine;
import shipping.mini.domain.Order;
import shipping.mini.domain.Parcel;
import shipping.mini.dto.OrderDetailDTO;
import shipping.mini.dto.request.CreateOrderRequest;

import static shipping.mini.mapper.AddressMapper.*;

import java.util.List;

public class OrderMapper {

	public static OrderDetailDTO mapToOrderDetailDTO(Order order, List<ItemLine> itemLines, List<Parcel> parcels) {
		return new OrderDetailDTO(order.getId(), order.getExternalOrderNumber(), order.getOrderStatus(),
				mapToAddressDTO(order.getDeliveryAddress()),
				itemLines.stream().map(ItemLineMapper::mapToItemLineDTO).toList(),
				ShipmentMapper.mapToShipmentDTO(order.getShipment(), parcels));
	}
	
	public static Order mapToOrderDO(CreateOrderRequest request, Address address, List<ItemLine> items) {
		return new Order(request.externalOrderNumber(), null, address, items);
	}
}
