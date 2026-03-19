package shipping.mini.dto;

import java.time.ZonedDateTime;
import java.util.List;

import shipping.mini.domain.ShipmentStatus;

public record ShipmentDTO(
		Long id, 
		ShipmentStatus status,
		ZonedDateTime shippedAt, 
		List<ParcelDTO> parcels) {
}
