package com.mini.shipment.infrastructure.searchquery.impl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.mini.shipment.dto.request.ShipmentSearchCriteria;
import com.mini.shipment.infrastructure.entity.ShipmentEntity;

@Component
public class ShipmentSpecificationBuilderComponent {

	private final List<IShipmentFilter> filters;

	public ShipmentSpecificationBuilderComponent(List<IShipmentFilter> filters) {
		this.filters = filters;
	}

	public Specification<ShipmentEntity> build(ShipmentSearchCriteria criteria) {
		Specification<ShipmentEntity> spec = Specification.unrestricted();
		for (IShipmentFilter filter : filters) {
			Specification<ShipmentEntity> s = filter.apply(criteria);
			if (s != null) {
				spec = spec.and(s);
			}
		}
		return spec;
	}
}
