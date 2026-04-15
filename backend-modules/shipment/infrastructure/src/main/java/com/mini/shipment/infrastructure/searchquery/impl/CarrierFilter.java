//package com.mini.shipment.infrastructure.searchquery.impl;
//
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Component;
//
//import com.mini.shipment.dto.request.ShipmentSearchCriteria;
//import com.mini.shipment.infrastructure.entity.ShipmentEntity;
//
//import jakarta.persistence.criteria.Join;
//import jakarta.persistence.criteria.JoinType;
//
//@Component
//public class CarrierFilter implements IShipmentFilter {
//
//	@Override
//	public Specification<ShipmentEntity> apply(ShipmentSearchCriteria criteria) {
//		if (criteria.carrier() == null)
//			return null;
//		
//		return (root, query,cb) -> {
//			query.distinct(true);
//			Join<ShipmentEntity, Parcel> join = root.join("parcels", JoinType.LEFT);
//			return cb.like(cb.lower(join.get("carrier")),
//				"%" + criteria.carrier().toLowerCase() + "%");
//		};
//	}
//
//}
