package com.mini.order.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import com.mini.order.domain.OrderDomain;
import com.mini.order.infrastructure.entity.OrderEntity;
import com.mini.order.infrastructure.jparepository.OrderJpaRepository;
import com.mini.order.infrastructure.mapper.OrderEntityMapper;
import com.mini.order.repository.OrderDomainRepository;

import shipping.mini.kernal.exception.EntityNotfoundException;

@Repository
public class OrderDomainRepositoryImpl implements OrderDomainRepository {

	private final OrderJpaRepository repository;
	private final OrderEntityMapper mapper;
	
	public OrderDomainRepositoryImpl(OrderJpaRepository repository, OrderEntityMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
	public OrderDomain findById(Long id) throws EntityNotfoundException{
		OrderEntity orderEntity = repository.findById(id)
				.orElseThrow(() -> new EntityNotfoundException("Order not found with id: " + id));
		return mapper.toDomain(orderEntity);
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
