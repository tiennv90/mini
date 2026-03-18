package shipping.mini.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import shipping.mini.domain.Parcel;
import shipping.mini.kernal.DataLoader;
import shipping.mini.repsitory.ParcelRepository;

@Component
public class ParcelDataLoader implements DataLoader<Long, Parcel>{

	private final ParcelRepository parcelRepository;
	
	public ParcelDataLoader(ParcelRepository parcelRepository) {
		this.parcelRepository = parcelRepository;
	}
	
	@Override
	public Map<Long, List<Parcel>> load(List<Long> keyIds) {
		List<Parcel> parcels = parcelRepository.findByShipmentIdIn(keyIds);
		return parcels.stream().collect(Collectors.groupingBy(p -> p.getShipment().getId()));
	}

}
