package shipping.mini.parcel.mapper;

import com.mini.parcel.domain.Parcel;

import shipping.mini.parcel.dto.ParcelDTO;

public class ParcelMapper {
	public static ParcelDTO mapToParcelDTO(Parcel parcel) {
		return new ParcelDTO(parcel.getId(),parcel.getCarrier(), parcel.getTrackingCode());
	}
}
