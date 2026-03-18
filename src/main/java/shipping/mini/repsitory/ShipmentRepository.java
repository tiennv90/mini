package shipping.mini.repsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import shipping.mini.domain.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>, JpaSpecificationExecutor<Shipment>{
	
	@Query("""
			select s from Shipment s
			left join fetch s.parcels
			where s.id = :id
			""")
	public Optional<Shipment> findShipmentDetailsById(Long id);
	
}

