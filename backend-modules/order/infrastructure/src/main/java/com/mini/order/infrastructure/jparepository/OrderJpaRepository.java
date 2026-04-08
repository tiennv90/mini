package com.mini.order.infrastructure.jparepository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mini.order.infrastructure.entity.OrderEntity;

public interface OrderJpaRepository extends CrudRepository<OrderEntity, Long> {
	Optional<OrderEntity> findById(Long id);
	boolean existsByExternalOrderNumber(String order);
}
