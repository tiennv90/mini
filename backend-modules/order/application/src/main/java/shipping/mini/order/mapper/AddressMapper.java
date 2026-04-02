package shipping.mini.order.mapper;

import shipping.mini.order.domain.Address;
import shipping.mini.order.dto.AddressDTO;

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
