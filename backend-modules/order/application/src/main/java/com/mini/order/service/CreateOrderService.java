package com.mini.order.service;

import com.mini.order.dto.OrderDetailDTO;
import com.mini.order.dto.request.CreateOrderRequest;

import com.mini.order.exception.OrderStatusConflictException;

public interface CreateOrderService {

	public OrderDetailDTO createOrder(CreateOrderRequest request) throws OrderStatusConflictException;
}
