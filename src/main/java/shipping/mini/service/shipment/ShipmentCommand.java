package shipping.mini.service.shipment;

import shipping.mini.domain.Shipment;
import shipping.mini.domain.ShipmentStatus;
import shipping.mini.exception.ResourceStateConflictException;

public interface ShipmentCommand {
	ShipmentStatus getTargetStatus();
	void execute(Shipment shipment) throws ResourceStateConflictException;
}
