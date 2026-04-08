package com.mini.order.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mini.order.domain.ItemLineDomain;
import com.mini.order.infrastructure.jparepository.ItemLineJpaRepository;
import com.mini.order.infrastructure.mapper.ItemLineEntityMapper;
import com.mini.order.repository.ItemLineDomainRepository;

@Repository
public class ItemLineDomainRepositoryImpl implements ItemLineDomainRepository {

	private final ItemLineJpaRepository repository;
	private final ItemLineEntityMapper mapper;
	
	public ItemLineDomainRepositoryImpl(ItemLineJpaRepository repository, ItemLineEntityMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
	public List<ItemLineDomain> findByOrderIdIn(List<Long> orderIds) {
		return repository.findByOrderIdIn(orderIds).stream()
				.map(mapper::toDomain).collect(Collectors.toList());
	}

}
