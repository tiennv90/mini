package com.mini.parcel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Parcel status has conflict")
public class ParcelStatusConflictException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 2064868590014517397L;

    public ParcelStatusConflictException(String message) {
        super(message);
    }

}

