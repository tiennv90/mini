package com.mini.order.service;

import com.mini.order.dto.OrderDetailDTO;

import shipping.mini.kernal.exception.EntityNotfoundException;

public interface OrderService {
	
	public OrderDetailDTO getOrderDetails(Long id) throws EntityNotfoundException;

//    public ShipmentDTO createShipment(Long orderId, CreateShipmentRequest request) throws EntityNotfoundException, ResourceStateConflictException;
    
}
