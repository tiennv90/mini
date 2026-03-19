package shipping.mini.dto;

public record ParcelDTO(
		Long id,
		String carrier,
		String trackingCode
		) {}
