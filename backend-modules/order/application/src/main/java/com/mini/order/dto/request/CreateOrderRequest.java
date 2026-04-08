package com.mini.order.dto.request;

import java.util.List;

import com.mini.order.dto.AddressDTO;
import com.mini.order.dto.ItemLineDTO;

public record CreateOrderRequest(String externalOrderNumber, AddressDTO address, List<ItemLineDTO> items) {
}
