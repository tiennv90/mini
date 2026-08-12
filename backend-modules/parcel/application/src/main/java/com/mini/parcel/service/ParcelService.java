package com.mini.parcel.service;

import java.util.List;

import com.mini.parcel.dto.ParcelDTO;
import com.mini.parcel.dto.request.AssignTrackingRequest;

import com.mini.parcel.exception.ParcelNotFoundException;
import com.mini.parcel.exception.ParcelStatusConflictException;

public interface ParcelService {

	public ParcelDTO assignTracking(Long parcelId, AssignTrackingRequest trackingReq) throws ParcelNotFoundException, ParcelStatusConflictException;

	public List<ParcelDTO> getParcelsByShipmentId(Long shipmentId);
}
