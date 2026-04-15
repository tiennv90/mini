package com.mini.shipment.infrastructure.jparepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.mini.shipment.infrastructure.entity.ShipmentEntity;



public interface ShipmentJpaRepository extends JpaRepository<ShipmentEntity, Long>, JpaSpecificationExecutor<ShipmentEntity>{
	@Query("""
			select s from Shipment s
			where s.id = :id
			""")
	public Optional<ShipmentEntity> findShipmentDetailsById(Long id);
}
