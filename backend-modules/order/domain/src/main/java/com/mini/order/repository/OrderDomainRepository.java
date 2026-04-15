package com.mini.order.repository;

import com.mini.order.domain.OrderDomain;

import shipping.mini.kernal.exception.EntityNotfoundException;

public interface OrderDomainRepository {
	OrderDomain findById(Long id) throws EntityNotfoundException;
	boolean existsByExternalOrderNumber(String order);
	OrderDomain save(OrderDomain order);
}
