package shipping.mini.repsitory;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import shipping.mini.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	Optional<Order> findById(Long id);
	
	boolean existsByExternalOrderNumber(String order);
}
