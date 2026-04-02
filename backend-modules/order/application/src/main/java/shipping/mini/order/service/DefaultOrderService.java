package shipping.mini.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;
import shipping.mini.order.component.ParcelDataLoader;
import shipping.mini.order.dataloader.ItemLineDataLoader;
import shipping.mini.order.domain.Address;
import shipping.mini.order.domain.ItemLine;
import shipping.mini.order.domain.Order;
import shipping.mini.order.dto.OrderDetailDTO;
import shipping.mini.order.dto.ParcelDTO;
import shipping.mini.order.dto.ShipmentDTO;
import shipping.mini.order.dto.request.CreateOrderRequest;
import shipping.mini.order.dto.request.CreateShipmentRequest;
import shipping.mini.order.mapper.AddressMapper;
import shipping.mini.order.mapper.ItemLineMapper;
import shipping.mini.order.mapper.OrderMapper;
import shipping.mini.order.repository.OrderRepository;
import shipping.mini.order.restclient.ShipmentRestClient;

@Service
public class DefaultOrderService implements OrderService {

	private final OrderRepository orderRepository;
	private final ParcelDataLoader parcelDataLoader;
	private final ItemLineDataLoader itemLineLoader;
	private final ShipmentRestClient shipmentRestClient;

	public DefaultOrderService(OrderRepository orderRepository, ParcelDataLoader parcelDataLoader,
			ItemLineDataLoader itemLineLoader,
			ShipmentRestClient shipmentRestClient) {
		this.orderRepository = orderRepository;
		this.parcelDataLoader = parcelDataLoader;
		this.itemLineLoader = itemLineLoader;
		this.shipmentRestClient = shipmentRestClient;
	}

	@Override
	public OrderDetailDTO getOrderDetails(Long id) throws EntityNotfoundException {
		Order order = getOrder(id);
		List<ItemLine> itemLines = itemLineLoader.loadAsList(List.of(id));

		Long shipmentId = order.getShipmentId();
		
		List<ParcelDTO> parcels = null;
		ShipmentDTO shipment = null;
		if  (shipmentId != null) {
			parcels = parcelDataLoader.loadAsList(List.of(shipmentId));
			shipment = shipmentRestClient.getShipment(shipmentId);
		}
		
		return OrderMapper.mapToOrderDetailDTO(order, itemLines,shipment, parcels);
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
		return OrderMapper.mapToOrderDetailDTO(orderRepository.save(order), items, null, null);
	}

//	@Override
//	public ShipmentDTO createShipment(Long orderId, CreateShipmentRequest request) throws EntityNotfoundException, ResourceStateConflictException {
//		Order order = getOrder(orderId);
//		Shipment shipment = order.createShipment(request);
//		order.setShipment(shipment);
//		return ShipmentMapper.mapToShipmentDTO(orderRepository.save(order).getShipment());
//	}

}
