package com.mini.shipment.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.repository.ShipmentDomainRepository;
import com.mini.shipment.infrastructure.entity.ShipmentEntity;
import com.mini.shipment.infrastructure.jparepository.ShipmentJpaRepository;
import com.mini.shipment.infrastructure.mapper.ShipmentEntityMapper;

@Repository
public class ShipmentDomainRepositoryIml implements ShipmentDomainRepository {

	private final ShipmentJpaRepository shipmentJpaRepository;
	private final ShipmentEntityMapper mapper;

	public ShipmentDomainRepositoryIml(ShipmentJpaRepository shipmentJpaRepository, ShipmentEntityMapper mapper) {
		this.shipmentJpaRepository = shipmentJpaRepository;
		this.mapper = mapper;
	}

	@Override
	public Optional<ShipmentDomain> findShipmentDetailsById(Long id) {
		Optional<ShipmentEntity> entity = shipmentJpaRepository.findShipmentDetailsById(id);
		return entity.map(mapper::toDomain);
	}

	@Override
	public Optional<ShipmentDomain> findById(Long id) {
		return shipmentJpaRepository.findById(id).map(mapper::toDomain);
	}

	@Override
	public ShipmentDomain save(ShipmentDomain shipmentDomain) {
		ShipmentEntity entity = shipmentJpaRepository.save(mapper.toEntity(shipmentDomain));
		return mapper.toDomain(entity);
	}

}
