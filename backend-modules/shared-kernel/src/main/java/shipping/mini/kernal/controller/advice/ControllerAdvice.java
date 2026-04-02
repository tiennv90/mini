package shipping.mini.kernal.controller.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shipping.mini.kernal.dto.ErrorResponseDTO;
import shipping.mini.kernal.exception.EntityNotfoundException;
import shipping.mini.kernal.exception.ResourceStateConflictException;


@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseDTO> handleEntityNotFound(EntityNotfoundException e) {
		var error = new ErrorResponseDTO(LocalDateTime.now(), e.getClass().getName(), e.getMessage());
		return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseDTO> handleResourceStateConfilct(ResourceStateConflictException e) {
		var error = new ErrorResponseDTO(LocalDateTime.now(), e.getClass().getName(), e.getMessage());
		return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.CONFLICT);
	}
}
