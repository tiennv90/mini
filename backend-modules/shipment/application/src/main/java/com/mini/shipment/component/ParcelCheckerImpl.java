package com.mini.shipment.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mini.shipment.domain.ParcelDomain;
import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.command.ParcelChecker;
import com.mini.shipment.gateway.ParcelGateway;
import com.mini.shipment.mapper.ParcelDomainMapper;

@Component
public class ParcelCheckerImpl implements ParcelChecker {

	private final ParcelGateway parcelGateway;
	private final ParcelDomainMapper mapper;
	
	public ParcelCheckerImpl(ParcelGateway parcelGateway, ParcelDomainMapper mapper) {
		this.parcelGateway = parcelGateway;
		this.mapper = mapper;
	}
	
	@Override
	public boolean allParcelsTracked(ShipmentDomain shipment) {
		return parcelGateway.findByShipmentIdIn(List.of(shipment.getId())).stream().map(mapper::toDomain)
				.allMatch(ParcelDomain::hasTracking);
	}

}
