package com.mini.shipment.infrastructure.searchquery.impl;

import com.mini.shipment.dto.request.ShipmentSearchCriteria;
import com.mini.shipment.infrastructure.entity.ShipmentEntity;
import com.mini.shipment.infrastructure.searchquery.ISearchFilter;

public interface IShipmentFilter extends ISearchFilter<ShipmentEntity, ShipmentSearchCriteria> {

}
