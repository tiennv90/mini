package shipping.mini.parcel.service;

import org.springframework.stereotype.Service;

import com.mini.parcel.domain.Parcel;
import com.mini.parcel.domain.ParcelDomain;
import com.mini.parcel.repository.ParcelDomainRepository;
import com.mini.parcel.repository.ParcelRepository;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;
import shipping.mini.parcel.dto.ParcelDTO;
import shipping.mini.parcel.dto.request.AssignTrackingRequest;
import shipping.mini.parcel.mapper.ParcelDomainMapper;
import shipping.mini.parcel.mapper.ParcelMapper;

@Service
public class DefaultParcelService implements ParcelService {

	private final ParcelDomainRepository parcelDomainRepository;
	private final ParcelDomainMapper mapper;
	
	public DefaultParcelService(ParcelDomainRepository parcelDomainRepository, ParcelDomainMapper mapper) {
		this.parcelDomainRepository = parcelDomainRepository;
		this.mapper = mapper;
	}

	@Override
	public ParcelDTO assignTracking(Long parcelId, AssignTrackingRequest req) throws EntityNotfoundException, ResourceStateConflictException {
		ParcelDomain parcel = getParcel(parcelId);
		parcel.assignTracking(req.trackingCode());
		return mapper.toDTo(parcelDomainRepository.save(parcel));
	}

	private ParcelDomain getParcel(Long parcelId) throws EntityNotfoundException {
		return parcelDomainRepository.findById(parcelId)
				.orElseThrow(() -> new EntityNotfoundException("Parcel not found for Id: " + parcelId));
	}
	

}
