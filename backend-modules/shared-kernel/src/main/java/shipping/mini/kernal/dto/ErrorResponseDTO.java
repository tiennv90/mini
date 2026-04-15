package shipping.mini.kernal.dto;

import java.time.LocalDateTime;

public record ErrorResponseDTO(LocalDateTime timestamp, String error, String message) {

}
