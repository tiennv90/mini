package com.mini.order.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mini.order.dto.ParcelDTO;
import com.mini.order.gateway.ParcelGateway;

import shipping.mini.kernal.dataloader.DataLoader;

@Component
public class ParcelDataLoader implements DataLoader<Long, ParcelDTO>{

	private final ParcelGateway parcelGateway;
	
	public ParcelDataLoader(ParcelGateway parcelGateway) {
		this.parcelGateway = parcelGateway;
	}
	
	@Override
	public Map<Long, List<ParcelDTO>> load(List<Long> keyIds) {
		List<ParcelDTO> parcels = parcelGateway.getParcelsByShipmentIds(keyIds);
		return parcels.stream().collect(Collectors.groupingBy(p -> p.shipmentId()));
	}

}
