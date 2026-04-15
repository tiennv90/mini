package com.mini.order.repository;

import java.util.List;

import com.mini.order.domain.ItemLineDomain;

public interface ItemLineDomainRepository {
	public List<ItemLineDomain> findByOrderIdIn(List<Long> orderIds);
}
