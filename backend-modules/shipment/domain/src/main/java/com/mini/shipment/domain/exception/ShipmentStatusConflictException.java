package com.mini.shipment.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Shipment status has conflict")
public class ShipmentStatusConflictException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 2064868590014517397L;

    public ShipmentStatusConflictException(String message) {
        super(message);
    }

}
