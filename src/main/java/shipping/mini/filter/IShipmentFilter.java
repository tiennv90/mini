package shipping.mini.filter;

import shipping.mini.domain.Shipment;
import shipping.mini.dto.ShipmentSearchCriteria;
import shipping.mini.kernal.ISearchFilter;

public interface IShipmentFilter extends ISearchFilter<Shipment, ShipmentSearchCriteria> {

}
