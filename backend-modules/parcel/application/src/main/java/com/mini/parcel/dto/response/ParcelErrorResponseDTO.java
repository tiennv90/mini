package com.mini.parcel.dto.response;

import java.time.LocalDateTime;

public record ParcelErrorResponseDTO(LocalDateTime timestamp, String error, String message) {

}
