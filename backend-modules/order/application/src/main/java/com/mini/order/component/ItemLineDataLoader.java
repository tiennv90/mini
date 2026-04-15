package com.mini.order.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mini.order.domain.ItemLineDomain;
import com.mini.order.repository.ItemLineDomainRepository;

import shipping.mini.kernal.dataloader.DataLoader;

@Component
public class ItemLineDataLoader implements DataLoader<Long, ItemLineDomain>{

	private final ItemLineDomainRepository itemLineDomainRepository;
	
	public ItemLineDataLoader(ItemLineDomainRepository itemLineDomainRepository) {
		this.itemLineDomainRepository = itemLineDomainRepository;
	}
	
	@Override
	public Map<Long, List<ItemLineDomain>> load(List<Long> keyIds) {
		List<ItemLineDomain> list = itemLineDomainRepository.findByOrderIdIn(keyIds);
		return list.stream().collect(Collectors.groupingBy(item -> item.getOrderId()));
	}

}
