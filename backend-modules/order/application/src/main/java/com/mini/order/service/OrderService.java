package com.mini.order.service;

import com.mini.order.dto.OrderDetailDTO;
import com.mini.order.dto.request.CreateOrderRequest;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;

public interface OrderService {
	
	public OrderDetailDTO getOrderDetails(Long id) throws EntityNotfoundException;

	public OrderDetailDTO createOrder(CreateOrderRequest request) throws ResourceStateConflictException;
	
//    public ShipmentDTO createShipment(Long orderId, CreateShipmentRequest request) throws EntityNotfoundException, ResourceStateConflictException;
    
}
