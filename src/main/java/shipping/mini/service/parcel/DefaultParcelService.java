package shipping.mini.service.parcel;

import org.springframework.stereotype.Service;

import shipping.mini.controller.mapper.ParcelMapper;
import shipping.mini.domain.Parcel;
import shipping.mini.dto.ParcelDTO;
import shipping.mini.dto.request.AssignTrackingRequest;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;
import shipping.mini.repsitory.ParcelRepository;

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
