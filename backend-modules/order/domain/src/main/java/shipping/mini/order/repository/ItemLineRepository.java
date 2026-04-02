package shipping.mini.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import shipping.mini.order.domain.ItemLine;

public interface ItemLineRepository extends CrudRepository<ItemLine, Long> {
	public List<ItemLine> findByOrderIdIn(List<Long> orderIds);
}
