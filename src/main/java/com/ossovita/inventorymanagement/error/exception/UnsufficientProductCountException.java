package com.ossovita.inventorymanagement.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnsufficientProductCountException extends RuntimeException {

    public UnsufficientProductCountException(String message) {
        super(message);
    }
}
