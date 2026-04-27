package com.mini.order.service;

import com.mini.order.dto.OrderDetailDTO;
import com.mini.order.dto.request.CreateOrderRequest;

import shipping.mini.kernal.exception.ResourceStateConflictException;

public interface CreateOrderService {

	public OrderDetailDTO createOrder(CreateOrderRequest request) throws ResourceStateConflictException;
}
