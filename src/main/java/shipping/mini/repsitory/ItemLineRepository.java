package shipping.mini.repsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import shipping.mini.domain.ItemLine;

public interface ItemLineRepository extends CrudRepository<ItemLine, Long> {
	public List<ItemLine> findByOrderIdIn(List<Long> orderIds);
}
