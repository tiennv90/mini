package com.mini.shipment.infrastructure.searchquery.impl;

import com.mini.shipment.dto.request.ShipmentSearchCriteria;
import com.mini.shipment.infrastructure.entity.ShipmentEntity;

import shipping.mini.kernal.filter.ISearchFilter;

public interface IShipmentFilter extends ISearchFilter<ShipmentEntity, ShipmentSearchCriteria> {

}
