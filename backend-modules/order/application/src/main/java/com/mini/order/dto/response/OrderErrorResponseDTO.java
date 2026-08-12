package com.mini.order.dto.response;

import java.time.LocalDateTime;

public record OrderErrorResponseDTO(LocalDateTime timestamp, String error, String message) {

}
