package shipping.mini.service.order;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import shipping.mini.component.ItemLineDataLoader;
import shipping.mini.component.ParcelDataLoader;
import shipping.mini.controller.mapper.AddressMapper;
import shipping.mini.controller.mapper.ItemLineMapper;
import shipping.mini.controller.mapper.OrderMapper;
import shipping.mini.controller.mapper.ShipmentMapper;
import shipping.mini.domain.Address;
import shipping.mini.domain.ItemLine;
import shipping.mini.domain.Order;
import shipping.mini.domain.Parcel;
import shipping.mini.domain.Shipment;
import shipping.mini.dto.OrderDetailDTO;
import shipping.mini.dto.ShipmentDTO;
import shipping.mini.dto.request.CreateOrderRequest;
import shipping.mini.dto.request.CreateShipmentRequest;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;
import shipping.mini.repsitory.OrderRepository;

@Service
public class DefaultOrderService implements OrderService {

	private final OrderRepository orderRepository;
	private final ParcelDataLoader parcelDataLoader;
	private final ItemLineDataLoader itemLineLoader;

	public DefaultOrderService(OrderRepository orderRepository, ParcelDataLoader parcelDataLoader,
			ItemLineDataLoader itemLineLoader) {
		this.orderRepository = orderRepository;
		this.parcelDataLoader = parcelDataLoader;
		this.itemLineLoader = itemLineLoader;
	}

	@Override
	public OrderDetailDTO getOrderDetails(Long id) throws EntityNotfoundException {
		Order order = getOrder(id);

		Map<Long, List<ItemLine>> itemlineMap = itemLineLoader.load(List.of(id));
		List<ItemLine> itemLines = itemlineMap.getOrDefault(id, List.of());

		Shipment shipment = order.getShipment();

		List<Parcel> parcels = List.of();
		if (shipment != null) {
			Map<Long, List<Parcel>> parcelMap = parcelDataLoader.load(List.of(shipment.getId()));
			parcels = parcelMap.getOrDefault(shipment.getId(), List.of());
		}

		return OrderMapper.mapToOrderDetailDTO(order, itemLines, parcels);
	}

	private Order getOrder(Long id) throws EntityNotfoundException {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new EntityNotfoundException("No order exists with ID " + id));
		return order;
	}

	@Override
	public OrderDetailDTO createOrder(CreateOrderRequest request) throws ResourceStateConflictException {
		if (orderRepository.existsByExternalOrderNumber(request.externalOrderNumber())) {
			throw new ResourceStateConflictException("Duplicate external order number");
		}
		Address address = AddressMapper.mapToAddressDO(request.address());
		List<ItemLine> items = request.items().stream().map(ItemLineMapper::mapToItemLineDO).toList();
		Order order = OrderMapper.mapToOrderDO(request, address, items);
		return OrderMapper.mapToOrderDetailDTO(orderRepository.save(order), items, null);
	}

	@Override
	public ShipmentDTO createShipment(Long orderId, CreateShipmentRequest request) throws EntityNotfoundException, ResourceStateConflictException {
		Order order = getOrder(orderId);
		Shipment shipment = order.createShipment(request);
		order.setShipment(shipment);
		return ShipmentMapper.mapToShipmentDTO(orderRepository.save(order).getShipment());
	}

}
