package com.mini.order.dto;

public record ItemLineDTO(Long orderId, String productName, Integer quantity) {
}
