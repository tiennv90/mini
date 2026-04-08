package com.mini.order.repository;

import java.util.Optional;

import com.mini.order.domain.OrderDomain;

public interface OrderDomainRepository {
	Optional<OrderDomain> findById(Long id);
	boolean existsByExternalOrderNumber(String order);
	OrderDomain save(OrderDomain order);
}
