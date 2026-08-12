package com.mini.parcel.advice;

import com.mini.parcel.dto.response.ParcelErrorResponseDTO;
import com.mini.parcel.exception.ParcelNotFoundException;
import com.mini.parcel.exception.ParcelStatusConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ParcelControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ParcelErrorResponseDTO> handleEntityNotFound(ParcelNotFoundException e) {
        var error = new ParcelErrorResponseDTO(LocalDateTime.now(), e.getClass().getName(), e.getMessage());
        return new ResponseEntity<ParcelErrorResponseDTO>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ParcelErrorResponseDTO> handleResourceStateConflict(ParcelStatusConflictException e) {
        var error = new ParcelErrorResponseDTO(LocalDateTime.now(), e.getClass().getName(), e.getMessage());
        return new ResponseEntity<ParcelErrorResponseDTO>(error, HttpStatus.CONFLICT);
    }
}
