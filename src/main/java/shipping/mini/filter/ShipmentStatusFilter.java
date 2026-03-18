package shipping.mini.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import shipping.mini.domain.Shipment;
import shipping.mini.dto.ShipmentSearchCriteria;

@Component
public class ShipmentStatusFilter implements IShipmentFilter {

	@Override
	public Specification<Shipment> apply(ShipmentSearchCriteria criteria) {
		if (criteria.status() == null) {
			return null;
		}
		return (root, query, cb) -> cb.equal(root.get("shipmentStatus"), criteria.status());
	}

}
