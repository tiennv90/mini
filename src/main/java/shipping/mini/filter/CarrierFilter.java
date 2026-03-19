package shipping.mini.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import shipping.mini.domain.Parcel;
import shipping.mini.domain.Shipment;
import shipping.mini.dto.ShipmentSearchCriteria;

@Component
public class CarrierFilter implements IShipmentFilter {

	@Override
	public Specification<Shipment> apply(ShipmentSearchCriteria criteria) {
		if (criteria.carrier() == null)
			return null;
		
		return (root, query,cb) -> {
			query.distinct(true);
			Join<Shipment, Parcel> join = root.join("parcels", JoinType.LEFT);
			return cb.like(cb.lower(join.get("carrier")),
				"%" + criteria.carrier().toLowerCase() + "%");
		};
	}

}
