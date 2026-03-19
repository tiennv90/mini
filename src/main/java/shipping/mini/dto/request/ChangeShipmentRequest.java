package shipping.mini.dto.request;

import shipping.mini.domain.ShipmentStatus;

public record ChangeShipmentRequest(ShipmentStatus newShipmentStatus) {

}
