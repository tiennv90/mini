package com.mini.parcel.service;

import java.util.List;

import com.mini.parcel.dto.ParcelDTO;
import com.mini.parcel.dto.request.AssignTrackingRequest;

import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;

public interface ParcelService {

	public ParcelDTO assignTracking(Long parcelId, AssignTrackingRequest trackingReq) throws EntityNotfoundException, ResourceStateConflictException;

	public List<ParcelDTO> getParcelsByShipmentId(Long shipmentId);
}
