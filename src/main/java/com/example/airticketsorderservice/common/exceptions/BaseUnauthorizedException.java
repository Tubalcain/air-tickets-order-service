package com.example.airticketsorderservice.common.exceptions;

public abstract class BaseUnauthorizedException extends RuntimeException {
    private static final long serialVersionUID = 3130677615686138367L;

    BaseUnauthorizedException(String message) {
        super(message);
    }

    public abstract ErrorCode getErrorCode();
}
