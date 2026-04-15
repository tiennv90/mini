package com.mini.parcel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mini.parcel.domain.Parcel;


public interface ParcelRepository extends CrudRepository<Parcel, Long>{
	List<Parcel> findByShipmentIdIn(List<Long> shipmentIds);
}
