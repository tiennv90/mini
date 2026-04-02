package shipping.mini.order.mapper;

import java.util.List;

import shipping.mini.order.dto.ParcelDTO;
import shipping.mini.order.dto.ShipmentDTO;

public class ShipmentMapper {
//	public static ShipmentDTO mapToShipmentDTO(Shipment shipment) {
//		if (shipment == null) return null;
//		return new ShipmentDTO(shipment.getId(), shipment.getShipmentStatus()
//				 ,shipment.getShippedAt()
//				, shipment.getParcels().stream().map(ParcelMapper::mapToParcelDTO).toList());
//	}
	
	public static ShipmentDTO mapToShipmentDTO(ShipmentDTO shipment, List<ParcelDTO> parcels) {
		if (shipment == null) return null;
		return new ShipmentDTO(shipment.id(), shipment.status()
				, shipment.shippedAt()
				, parcels);
	}	
}
