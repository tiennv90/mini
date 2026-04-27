package com.mini.order.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mini.order.dto.OrderDetailDTO;
import com.mini.order.dto.request.CreateOrderRequest;
import com.mini.order.service.CreateOrderService;
import com.mini.order.service.OrderService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;

@RestController
@RequestMapping("/v1/orders")
public class OrderRestController {

	private final OrderService orderService;
	private final CreateOrderService createOrderService;

	public OrderRestController(OrderService orderService, CreateOrderService createOrderService) {
		this.orderService = orderService;
		this.createOrderService = createOrderService;
	}

	@PostMapping
	public OrderDetailDTO create(@RequestBody CreateOrderRequest request) throws ResourceStateConflictException {
		return createOrderService.createOrder(request);
	}

	@GetMapping("/{orderId}")
	@RateLimiter(name = "backendA")
	public OrderDetailDTO getOrderDetails(@PathVariable Long orderId) throws EntityNotfoundException {
		return orderService.getOrderDetails(orderId);
	}
	
	
}
