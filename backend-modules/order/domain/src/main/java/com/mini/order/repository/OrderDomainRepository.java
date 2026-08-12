package com.mini.order.repository;

import com.mini.order.domain.OrderDomain;

import com.mini.order.exception.OrderNotFoundException;

public interface OrderDomainRepository {
	OrderDomain findById(Long id) throws OrderNotFoundException;
	boolean existsByExternalOrderNumber(String order);
	OrderDomain save(OrderDomain order);
}
