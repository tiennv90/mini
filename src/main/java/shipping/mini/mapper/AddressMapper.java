package shipping.mini.mapper;

import shipping.mini.domain.Address;
import shipping.mini.dto.AddressDTO;

public class AddressMapper {
	
	public static AddressDTO mapToAddressDTO(Address address) {
		return new AddressDTO(address.getStreet(), address.getHouseNumber(),
				address.getCity(), address.getPostalCode(), address.getCountry());
	}
	
	public static Address mapToAddressDO(AddressDTO addressDTO) {
		return new Address(addressDTO.street(), 
				addressDTO.houseNumber(), 
				addressDTO.postalCode(), 
				addressDTO.city(), 
				addressDTO.country());
	}
}
