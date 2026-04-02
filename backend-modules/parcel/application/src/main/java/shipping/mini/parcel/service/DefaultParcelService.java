package shipping.mini.parcel.service;

import org.springframework.stereotype.Service;

import com.mini.parcel.domain.Parcel;
import com.mini.parcel.repository.ParcelRepository;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;
import shipping.mini.parcel.dto.ParcelDTO;
import shipping.mini.parcel.dto.request.AssignTrackingRequest;
import shipping.mini.parcel.mapper.ParcelMapper;

@Service
public class DefaultParcelService implements ParcelService {

	private final ParcelRepository parcelRepository;
	
	public DefaultParcelService(ParcelRepository parcelRepository) {
		this.parcelRepository = parcelRepository;
	}

	@Override
	public ParcelDTO assignTracking(Long parcelId, AssignTrackingRequest req) throws EntityNotfoundException, ResourceStateConflictException {
		Parcel parcel = getParcel(parcelId);
		parcel.assignTracking(req.trackingCode());
		return ParcelMapper.mapToParcelDTO(parcelRepository.save(parcel));
	}

	private Parcel getParcel(Long parcelId) throws EntityNotfoundException {
		return parcelRepository.findById(parcelId)
				.orElseThrow(() -> new EntityNotfoundException("Parcel not found for Id: " + parcelId));
	}
	

}
