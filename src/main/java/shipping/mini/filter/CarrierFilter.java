package shipping.mini.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import shipping.mini.domain.Shipment;
import shipping.mini.dto.ShipmentSearchCriteria;

@Component
public class CarrierFilter implements IShipmentFilter {

	@Override
	public Specification<Shipment> apply(ShipmentSearchCriteria criteria) {
		if (criteria.carrier() == null)
			return null;
		
		return (root, query, cb) -> cb.like(cb.lower(root.get("carrier")),
				"%" + criteria.carrier().toLowerCase() + "%");
	}

}
