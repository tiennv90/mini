package shipping.mini.service.parcel;

import shipping.mini.dto.ParcelDTO;
import shipping.mini.dto.request.AssignTrackingRequest;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;

public interface ParcelService {

	public ParcelDTO assignTracking(Long parcelId, AssignTrackingRequest trackingReq) throws EntityNotfoundException, ResourceStateConflictException;
}
