package shipping.mini.service.shipment;

import org.springframework.stereotype.Component;

import shipping.mini.domain.Shipment;
import shipping.mini.domain.ShipmentStatus;
import shipping.mini.exception.ResourceStateConflictException;

@Component
public class PackCommand implements ShipmentCommand {

	@Override
	public void execute(Shipment shipment) throws ResourceStateConflictException {
		if (!shipment.getShipmentStatus().equals(ShipmentStatus.CREATED)) {
			throw new ResourceStateConflictException("Shipment state is not ready to be packed");
		}
		shipment.setShipmentStatus(ShipmentStatus.PACKED);
	}

	@Override
	public ShipmentStatus getTargetStatus() {
		return ShipmentStatus.PACKED;
	}

}
