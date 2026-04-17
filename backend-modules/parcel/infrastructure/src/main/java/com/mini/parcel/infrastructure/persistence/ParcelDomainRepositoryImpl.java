package com.mini.parcel.infrastructure.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mini.parcel.domain.ParcelDomain;
import com.mini.parcel.infrastructure.entity.ParcelEntity;
import com.mini.parcel.infrastructure.jparepository.ParcelJpaRepository;
import com.mini.parcel.infrastructure.mapper.ParcelEntityMapper;
import com.mini.parcel.repository.ParcelDomainRepository;

@Repository
public class ParcelDomainRepositoryImpl implements ParcelDomainRepository {

	private final ParcelJpaRepository repository;
	private final ParcelEntityMapper mapper;
	
	ParcelDomainRepositoryImpl(ParcelJpaRepository repository, ParcelEntityMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	@Override
	public List<ParcelDomain> findByShipmentIdIn(List<Long> shipmentIds) {
		return repository.findByShipmentIdIn(shipmentIds).stream()
				.map(mapper::toDomain).collect(Collectors.toList());
	}
	@Override
	public Optional<ParcelDomain> findById(Long id) {
		return repository.findById(id).map(mapper::toDomain);
	}
	@Override
	public ParcelDomain save(ParcelDomain parcel) {
		ParcelEntity entity = mapper.toEntity(parcel);
		return mapper.toDomain(repository.save(entity));
	}
	
	@Override
	public List<ParcelDomain> findByShipmentId(Long shipmentId) {
		return repository.findByShipmentId(shipmentId).stream()
				.map(mapper::toDomain).collect(Collectors.toList());
	}

}
