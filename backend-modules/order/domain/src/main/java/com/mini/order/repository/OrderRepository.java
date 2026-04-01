package com.mini.order.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mini.order.domain.Order;


public interface OrderRepository extends CrudRepository<Order, Long> {
	Optional<Order> findById(Long id);
	boolean existsByExternalOrderNumber(String order);
}
