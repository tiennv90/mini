package com.mini.shipment.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mini.shipment.dto.ParcelDTO;
import com.mini.shipment.gateway.ParcelGateway;

import shipping.mini.kernal.dataloader.DataLoader;


@Component
public class ParcelDataLoader implements DataLoader<Long, ParcelDTO>{

	private final ParcelGateway parcelGateway;
	
	public ParcelDataLoader(ParcelGateway parcelGateway) {
		this.parcelGateway = parcelGateway;
	}
	
	@Override
	public Map<Long, List<ParcelDTO>> load(List<Long> keyIds) {
		List<ParcelDTO> parcels = parcelGateway.findByShipmentIdIn(keyIds);
		return parcels.stream().collect(Collectors.groupingBy(ParcelDTO::shipmentId));
	}

}
