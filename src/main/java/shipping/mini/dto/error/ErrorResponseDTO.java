package shipping.mini.dto.error;

import java.time.LocalDateTime;

public record ErrorResponseDTO(LocalDateTime timestamp, String error, String message) {

}
