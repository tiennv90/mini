package com.mini.parcel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mini.parcel.domain.ParcelDomain;
import com.mini.parcel.dto.ParcelDTO;
import com.mini.parcel.dto.request.AssignTrackingRequest;
import com.mini.parcel.mapper.ParcelDomainMapper;
import com.mini.parcel.repository.ParcelDomainRepository;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;

@Service
public class DefaultParcelService implements ParcelService {

	private final ParcelDomainRepository parcelDomainRepository;
	private final ParcelDomainMapper mapper;
	
	public DefaultParcelService(ParcelDomainRepository parcelDomainRepository, ParcelDomainMapper mapper) {
		this.parcelDomainRepository = parcelDomainRepository;
		this.mapper = mapper;
	}

	@Override
	public ParcelDTO assignTracking(Long parcelId, AssignTrackingRequest req) throws EntityNotfoundException, ResourceStateConflictException {
		ParcelDomain parcel = getParcel(parcelId);
		parcel.assignTracking(req.trackingCode());
		return mapper.toDTo(parcelDomainRepository.save(parcel));
	}

	private ParcelDomain getParcel(Long parcelId) throws EntityNotfoundException {
		return parcelDomainRepository.findById(parcelId)
				.orElseThrow(() -> new EntityNotfoundException("Parcel not found for Id: " + parcelId));
	}

	@Override
	public List<ParcelDTO> getParcelsByShipmentId(Long shipmentId) {
		return parcelDomainRepository.findByShipmentId(shipmentId)
				.stream().map(mapper::toDTo).collect(Collectors.toList());
	}
	

}
