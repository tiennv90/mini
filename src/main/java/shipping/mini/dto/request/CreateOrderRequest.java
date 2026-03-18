package shipping.mini.dto.request;

import java.util.List;

import shipping.mini.dto.AddressDTO;
import shipping.mini.dto.ItemLineDTO;

public record CreateOrderRequest(
		String externalOrderNumber, 
		AddressDTO address, 
		List<ItemLineDTO> items) {
}
