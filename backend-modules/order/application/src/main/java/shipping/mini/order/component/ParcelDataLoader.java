package shipping.mini.order.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import shipping.mini.kernal.dataloader.DataLoader;
import shipping.mini.order.dto.ParcelDTO;
import shipping.mini.order.restclient.ParcelRestClient;


@Component
public class ParcelDataLoader implements DataLoader<Long, ParcelDTO>{

	private final ParcelRestClient parcelClient;
	
	public ParcelDataLoader(ParcelRestClient parcelClient) {
		this.parcelClient = parcelClient;
	}
	
	@Override
	public Map<Long, List<ParcelDTO>> load(List<Long> keyIds) {
		List<ParcelDTO> parcels = parcelClient.getParcelsByShipmentIds(keyIds);
		return parcels.stream().collect(Collectors.groupingBy(p -> p.shipmentId()));
	}

}
