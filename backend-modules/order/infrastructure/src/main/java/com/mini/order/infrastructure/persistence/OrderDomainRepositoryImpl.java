package com.mini.order.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mini.order.domain.OrderDomain;
import com.mini.order.infrastructure.entity.OrderEntity;
import com.mini.order.infrastructure.jparepository.OrderJpaRepository;
import com.mini.order.infrastructure.mapper.OrderEntityMapper;
import com.mini.order.repository.OrderDomainRepository;

@Repository
public class OrderDomainRepositoryImpl implements OrderDomainRepository {

	private final OrderJpaRepository repository;
	private final OrderEntityMapper mapper;
	
	public OrderDomainRepositoryImpl(OrderJpaRepository repository, OrderEntityMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
	public Optional<OrderDomain> findById(Long id) {
		return repository.findById(id).map(mapper::toDomain);
	}

	@Override
	public boolean existsByExternalOrderNumber(String order) {
		return repository.existsByExternalOrderNumber(order);
	}

	@Override
	public OrderDomain save(OrderDomain order) {
		OrderEntity entity = mapper.toEntity(order);
		OrderEntity saved = repository.save(entity);
		return mapper.toDomain(saved);
	}

}
