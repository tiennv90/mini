package com.mini.shipment.searchquery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.dto.request.ShipmentSearchCriteria;

public interface ShipmentSearchQueryService {

	Page<ShipmentDomain> search(ShipmentSearchCriteria request, Pageable pageable);
}
