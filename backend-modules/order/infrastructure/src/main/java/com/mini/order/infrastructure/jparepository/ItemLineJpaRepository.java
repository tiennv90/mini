package com.mini.order.infrastructure.jparepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mini.order.infrastructure.entity.ItemLineEntity;

public interface ItemLineJpaRepository extends CrudRepository<ItemLineEntity, Long> {
	public List<ItemLineEntity> findByOrderIdIn(List<Long> orderIds);
}
