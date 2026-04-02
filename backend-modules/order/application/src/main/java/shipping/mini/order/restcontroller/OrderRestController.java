package shipping.mini.order.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;
import shipping.mini.order.dto.OrderDetailDTO;
import shipping.mini.order.dto.request.CreateOrderRequest;
import shipping.mini.order.service.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderRestController {

	private final OrderService orderService;

	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public OrderDetailDTO create(@RequestBody CreateOrderRequest request) throws ResourceStateConflictException {
		return orderService.createOrder(request);
	}

//	@PostMapping("/{id}/shipment")
//	public ShipmentDTO createShipment(@PathVariable Long id, @RequestBody CreateShipmentRequest req)
//			throws EntityNotfoundException, ResourceStateConflictException {
//		return orderService.createShipment(id, req);
//	}

	@GetMapping("/{orderId}")
	public OrderDetailDTO getOrderDetails(@PathVariable Long orderId) throws EntityNotfoundException {
		return orderService.getOrderDetails(orderId);
	}
}
