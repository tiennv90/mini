package shipping.mini.order.service;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;
import shipping.mini.order.dto.OrderDetailDTO;
import shipping.mini.order.dto.request.CreateOrderRequest;

public interface OrderService {
	
	public OrderDetailDTO getOrderDetails(Long id) throws EntityNotfoundException;

	public OrderDetailDTO createOrder(CreateOrderRequest request) throws ResourceStateConflictException;
	
//    public ShipmentDTO createShipment(Long orderId, CreateShipmentRequest request) throws EntityNotfoundException, ResourceStateConflictException;
    
}
