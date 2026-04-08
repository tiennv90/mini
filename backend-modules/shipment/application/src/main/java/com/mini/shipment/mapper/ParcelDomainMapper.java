package com.mini.shipment.mapper;

import org.mapstruct.Mapper;

import com.mini.shipment.domain.ParcelDomain;
import com.mini.shipment.dto.ParcelDTO;

@Mapper(componentModel = "spring")
public interface ParcelDomainMapper {
	
	ParcelDomain toDomain(ParcelDTO parcelDT);

}
