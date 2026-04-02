package shipping.mini.order.dto.request;

import java.util.List;

import shipping.mini.order.dto.AddressDTO;
import shipping.mini.order.dto.ItemLineDTO;

public record CreateOrderRequest(String externalOrderNumber, AddressDTO address, List<ItemLineDTO> items) {
}
