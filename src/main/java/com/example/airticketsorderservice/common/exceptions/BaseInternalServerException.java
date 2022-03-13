package com.example.airticketsorderservice.common.exceptions;

public abstract class BaseInternalServerException extends RuntimeException {
    private static final long serialVersionUID = 3130677615686138367L;

    BaseInternalServerException(String message) {
        super(message);
    }

    public abstract ErrorCode getErrorCode();
}
