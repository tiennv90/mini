package com.mini.shipment.infrastructure.searchquery.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.dto.request.ShipmentSearchCriteria;
import com.mini.shipment.infrastructure.entity.ShipmentEntity;
import com.mini.shipment.infrastructure.jparepository.ShipmentJpaRepository;
import com.mini.shipment.infrastructure.mapper.ShipmentEntityMapper;
import com.mini.shipment.searchquery.ShipmentSearchQueryService;

@Service
public class ShipmentSearchQueryServiceImpl implements ShipmentSearchQueryService {

	private final ShipmentSpecificationBuilderComponent specBuilderComponent;
	private final ShipmentJpaRepository shipmentRepository;
	private final ShipmentEntityMapper mapper;

	public ShipmentSearchQueryServiceImpl(ShipmentSpecificationBuilderComponent specBuilderComponent,
			ShipmentEntityMapper mapper, ShipmentJpaRepository shipmentRepository) {
		this.specBuilderComponent = specBuilderComponent;
		this.shipmentRepository = shipmentRepository;
		this.mapper = mapper;
	}

	@Override
	public Page<ShipmentDomain> search(ShipmentSearchCriteria request, Pageable pageable) {
		Specification<ShipmentEntity> spec = specBuilderComponent.build(request);
		Page<ShipmentEntity> shipmentsPage = shipmentRepository.findAll(spec, pageable);
		return shipmentsPage.map(mapper::toDomain);
	}

}
