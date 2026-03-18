package shipping.mini.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shipping.mini.dto.OrderDetailDTO;
import shipping.mini.dto.request.CreateOrderRequest;
import shipping.mini.dto.request.CreateShipmentRequest;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;
import shipping.mini.service.order.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public OrderDetailDTO create(@RequestBody CreateOrderRequest request) throws ResourceStateConflictException {
		return orderService.createOrder(request);
	}

	@PostMapping("/{id}/shipment")
	public ResponseEntity<Void> createShipment(@PathVariable Long id, @RequestBody CreateShipmentRequest req)
			throws EntityNotfoundException, ResourceStateConflictException {
		orderService.createShipment(id, req);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{orderId}")
	public OrderDetailDTO getOrderDetails(@PathVariable Long orderId) throws EntityNotfoundException {
		return orderService.getOrderDetails(orderId);
	}
}
