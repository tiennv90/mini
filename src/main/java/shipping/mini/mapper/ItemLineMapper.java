package shipping.mini.mapper;

import shipping.mini.domain.ItemLine;
import shipping.mini.dto.ItemLineDTO;

public class ItemLineMapper {
	public static ItemLineDTO mapToItemLineDTO(ItemLine itemLine) {
		return new ItemLineDTO(itemLine.getProductName(), itemLine.getQuantity());
	}
	
	public static ItemLine mapToItemLineDO(ItemLineDTO itemLineDTO) {
		return new ItemLine(itemLineDTO.productName(), itemLineDTO.quantity());
	}
}
