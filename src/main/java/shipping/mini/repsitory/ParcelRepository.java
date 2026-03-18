package shipping.mini.repsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import shipping.mini.domain.Parcel;

public interface ParcelRepository extends CrudRepository<Parcel, Long>{
	List<Parcel> findByShipmentIdIn(List<Long> shipmentIds);
	
}
