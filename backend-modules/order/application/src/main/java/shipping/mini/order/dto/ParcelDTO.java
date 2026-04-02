package shipping.mini.order.dto;

public record ParcelDTO(Long id, Long shipmentId, String carrier, String trackingCode) {
}
