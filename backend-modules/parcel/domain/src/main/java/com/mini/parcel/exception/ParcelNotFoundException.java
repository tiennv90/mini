package com.mini.parcel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Parcel not found")
public class ParcelNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 6943012653865812164L;

    public ParcelNotFoundException(String message) {
        super(message);
    }

}
