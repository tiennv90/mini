package shipping.mini.service.order;

import shipping.mini.dto.OrderDetailDTO;
import shipping.mini.dto.ShipmentDTO;
import shipping.mini.dto.request.CreateOrderRequest;
import shipping.mini.dto.request.CreateShipmentRequest;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;

public interface OrderService {
	public OrderDetailDTO getOrderDetails(Long id) throws EntityNotfoundException;

	public OrderDetailDTO createOrder(CreateOrderRequest request) throws ResourceStateConflictException;
	
    public ShipmentDTO createShipment(Long orderId, CreateShipmentRequest request) throws EntityNotfoundException, ResourceStateConflictException;
}
