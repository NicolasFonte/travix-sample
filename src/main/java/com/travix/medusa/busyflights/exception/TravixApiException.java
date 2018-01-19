package com.travix.medusa.busyflights.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Flights could not be filtered")
public class TravixApiException extends Exception {

    public TravixApiException(String msg) {
        super(msg);
    }

}
