package shipping.mini.service.shipment;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

import shipping.mini.domain.Shipment;
import shipping.mini.domain.ShipmentStatus;
import shipping.mini.exception.ResourceStateConflictException;

@Component
public class ShipCommand implements ShipmentCommand {

	@Override
	public void execute(Shipment shipment) throws ResourceStateConflictException {
		
		if (!shipment.getShipmentStatus().equals(ShipmentStatus.PACKED)) {
			throw new ResourceStateConflictException("Shipment state is not ready to be shipped");
		}
		boolean allTracked = shipment.getParcels().stream().allMatch(p -> p.hasTracking());
		if (!allTracked) {
			throw new ResourceStateConflictException("All parcels must have tracking code");
		}
		shipment.setShipmentStatus(ShipmentStatus.SHIPPED);
		shipment.setShippedAt(ZonedDateTime.now());
	}

	@Override
	public ShipmentStatus getTargetStatus() {
		return ShipmentStatus.SHIPPED;
	}

}
