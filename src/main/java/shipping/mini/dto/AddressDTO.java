package shipping.mini.dto;

public record AddressDTO(
		String street,
		String houseNumber,
		String city,
		String postalCode,
		String country
		) {}
