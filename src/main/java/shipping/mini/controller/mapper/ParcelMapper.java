package shipping.mini.controller.mapper;

import shipping.mini.domain.Parcel;
import shipping.mini.dto.ParcelDTO;

public class ParcelMapper {
	public static ParcelDTO mapToParcelDTO(Parcel parcel) {
		return new ParcelDTO(parcel.getId(), parcel.getTrackingCode());
	}
}
