package com.mini.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Order status has conflict")
public class OrderStatusConflictException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 2064868590014517397L;

    public OrderStatusConflictException(String message) {
        super(message);
    }

}

