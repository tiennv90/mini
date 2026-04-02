package shipping.mini.order.mapper;

import shipping.mini.order.domain.ItemLine;
import shipping.mini.order.dto.ItemLineDTO;

public class ItemLineMapper {
	public static ItemLineDTO mapToItemLineDTO(ItemLine itemLine) {
		return new ItemLineDTO(itemLine.getProductName(), itemLine.getQuantity());
	}
	
	public static ItemLine mapToItemLineDO(ItemLineDTO itemLineDTO) {
		return new ItemLine(itemLineDTO.productName(), itemLineDTO.quantity());
	}
}
