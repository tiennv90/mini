package shipping.mini.repsitory;

import org.springframework.data.repository.CrudRepository;

import shipping.mini.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{

}
