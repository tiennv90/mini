package com.mini.parcel.infrastructure.jparepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mini.parcel.infrastructure.entity.ParcelEntity;

public interface ParcelJpaRepository extends CrudRepository<ParcelEntity, Long> {
	List<ParcelEntity> findByShipmentIdIn(List<Long> shipmentIds);
	List<ParcelEntity> findByShipmentId(Long shipmentId);
}
