package com.mini.parcel.dataloader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mini.parcel.domain.ParcelDomain;
import com.mini.parcel.repository.ParcelDomainRepository;

import shipping.mini.kernal.dataloader.DataLoader;

@Component
public class ParcelDataLoader implements DataLoader<Long, ParcelDomain>{

	private final ParcelDomainRepository parcelDomainRepository;
	
	public ParcelDataLoader(ParcelDomainRepository parcelDomainRepository) {
		this.parcelDomainRepository = parcelDomainRepository;
	}
	
	@Override
	public Map<Long, List<ParcelDomain>> load(List<Long> keyIds) {
		List<ParcelDomain> parcels = parcelDomainRepository.findByShipmentIdIn(keyIds);
		return parcels.stream().collect(Collectors.groupingBy(p -> p.getShipmentId()));
	}

}
