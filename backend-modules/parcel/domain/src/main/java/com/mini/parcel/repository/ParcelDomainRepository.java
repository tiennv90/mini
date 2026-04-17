package com.mini.parcel.repository;

import java.util.List;
import java.util.Optional;

import com.mini.parcel.domain.ParcelDomain;

public interface ParcelDomainRepository {
	List<ParcelDomain> findByShipmentIdIn(List<Long> shipmentIds);
	Optional<ParcelDomain> findById(Long id);
	ParcelDomain save(ParcelDomain parcel);
	List<ParcelDomain> findByShipmentId(Long shipmentId);
}
