package com.mini.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Order not found")
public class OrderNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 6943012653865812164L;

    public OrderNotFoundException(String message) {
        super(message);
    }

}
