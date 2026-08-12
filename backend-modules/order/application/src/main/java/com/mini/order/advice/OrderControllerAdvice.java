package com.mini.order.advice;

import com.mini.order.dto.response.OrderErrorResponseDTO;
import com.mini.order.exception.OrderNotFoundException;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class OrderControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<OrderErrorResponseDTO> handleEntityNotFound(OrderNotFoundException e) {
        var error = new OrderErrorResponseDTO(LocalDateTime.now(), e.getClass().getName(), e.getMessage());
        return new ResponseEntity<OrderErrorResponseDTO>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderErrorResponseDTO> handleResourceStateConflict(OrderNotFoundException e) {
        var error = new OrderErrorResponseDTO(LocalDateTime.now(), e.getClass().getName(), e.getMessage());
        return new ResponseEntity<OrderErrorResponseDTO>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<OrderErrorResponseDTO> handleTooManyRequest(RequestNotPermitted e) {
        var error = new OrderErrorResponseDTO(LocalDateTime.now(), e.getClass().getName(), e.getMessage());
        return new ResponseEntity<OrderErrorResponseDTO>(error, HttpStatus.TOO_MANY_REQUESTS);
    }
}