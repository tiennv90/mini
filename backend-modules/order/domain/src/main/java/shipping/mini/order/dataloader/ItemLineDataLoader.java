package shipping.mini.order.dataloader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import shipping.mini.kernal.dataloader.DataLoader;
import shipping.mini.order.domain.ItemLine;
import shipping.mini.order.repository.ItemLineRepository;


@Component
public class ItemLineDataLoader implements DataLoader<Long, ItemLine>{

	private final ItemLineRepository itemLineRepository;
	
	public ItemLineDataLoader(ItemLineRepository itemLineRepository) {
		this.itemLineRepository = itemLineRepository;
	}
	
	@Override
	public Map<Long, List<ItemLine>> load(List<Long> keyIds) {
		List<ItemLine> list = itemLineRepository.findByOrderIdIn(keyIds);
		return list.stream().collect(Collectors.groupingBy(item -> item.getOrder().getId()));
	}

}
