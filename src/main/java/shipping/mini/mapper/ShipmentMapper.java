package shipping.mini.mapper;

import java.util.List;

import shipping.mini.domain.Parcel;
import shipping.mini.domain.Shipment;
import shipping.mini.dto.ShipmentDTO;

public class ShipmentMapper {
	public static ShipmentDTO mapToShipmentDTO(Shipment shipment) {
		if (shipment == null) return null;
		return new ShipmentDTO(shipment.getId(), shipment.getShipmentStatus()
				 ,shipment.getShippedAt()
				, shipment.getParcels().stream().map(ParcelMapper::mapToParcelDTO).toList());
	}
	
	public static ShipmentDTO mapToShipmentDTO(Shipment shipment, List<Parcel> parcels) {
		if (shipment == null) return null;
		return new ShipmentDTO(shipment.getId(), shipment.getShipmentStatus()
				, shipment.getShippedAt()
				, parcels.stream().map(ParcelMapper::mapToParcelDTO).toList());
	}	
}
