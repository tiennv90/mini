package com.mini.shipment.infrastructure.searchquery.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.mini.shipment.dto.request.ShipmentSearchCriteria;
import com.mini.shipment.infrastructure.entity.ShipmentEntity;

@Component
public class ShipmentStatusFilter implements IShipmentFilter {

	@Override
	public Specification<ShipmentEntity> apply(ShipmentSearchCriteria criteria) {
		if (criteria.status() == null) {
			return null;
		}
		return (root, query, cb) -> cb.equal(root.get("shipmentStatus"), criteria.status());
	}

}
