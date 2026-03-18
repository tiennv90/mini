package shipping.mini.component;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import shipping.mini.domain.Shipment;
import shipping.mini.dto.ShipmentSearchCriteria;
import shipping.mini.filter.IShipmentFilter;

@Component
public class ShipmentSpecificationBuilderComponent {

	private final List<IShipmentFilter> filters;

	public ShipmentSpecificationBuilderComponent(List<IShipmentFilter> filters) {
		this.filters = filters;
	}

	public Specification<Shipment> build(ShipmentSearchCriteria criteria) {
		Specification<Shipment> spec = Specification.unrestricted();
		for (IShipmentFilter filter : filters) {
			Specification<Shipment> s = filter.apply(criteria);
			if (s != null) {
				spec = spec.and(s);
			}
		}
		return spec;
	}
}
