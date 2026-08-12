package com.mini.order.service;

import com.mini.order.dto.OrderDetailDTO;

import com.mini.order.exception.OrderNotFoundException;

public interface OrderService {
	
	public OrderDetailDTO getOrderDetails(Long id) throws OrderNotFoundException;

//    public ShipmentDTO createShipment(Long orderId, CreateShipmentRequest request) throws EntityNotfoundException, ResourceStateConflictException;
	OrderDetailDTO getOrderView(Long id) throws OrderNotFoundException;
    
}
