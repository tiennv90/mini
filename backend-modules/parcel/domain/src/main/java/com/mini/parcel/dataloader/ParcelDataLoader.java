package com.mini.parcel.dataloader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mini.parcel.domain.Parcel;
import com.mini.parcel.repository.ParcelRepository;

import shipping.mini.kernal.dataloader.DataLoader;

@Component
public class ParcelDataLoader implements DataLoader<Long, Parcel>{

	private final ParcelRepository parcelRepository;
	
	public ParcelDataLoader(ParcelRepository parcelRepository) {
		this.parcelRepository = parcelRepository;
	}
	
	@Override
	public Map<Long, List<Parcel>> load(List<Long> keyIds) {
		List<Parcel> parcels = parcelRepository.findByShipmentIdIn(keyIds);
		return parcels.stream().collect(Collectors.groupingBy(p -> p.getShipmentId()));
	}

}
