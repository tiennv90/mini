package com.mini.shipment.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Shipment not found")
public class ShipmentNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 6943012653865812164L;

    public ShipmentNotFoundException(String message) {
        super(message);
    }

}
