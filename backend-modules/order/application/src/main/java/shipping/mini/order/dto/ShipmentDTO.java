package shipping.mini.order.dto;

import java.time.ZonedDateTime;
import java.util.List;

public record ShipmentDTO(Long id, ShipmentStatusDTO status, ZonedDateTime shippedAt, List<ParcelDTO> parcels) {
}
