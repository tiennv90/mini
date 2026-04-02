package shipping.mini.parcel.service;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;
import shipping.mini.parcel.dto.ParcelDTO;
import shipping.mini.parcel.dto.request.AssignTrackingRequest;

public interface ParcelService {

	public ParcelDTO assignTracking(Long parcelId, AssignTrackingRequest trackingReq) throws EntityNotfoundException, ResourceStateConflictException;
}
