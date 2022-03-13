package com.example.airticketsorderservice.common.exceptions;

public abstract class BaseConflictException extends RuntimeException {
    private static final long serialVersionUID = 3130677615686138367L;

    BaseConflictException(String message) {
        super(message);
    }

    public abstract ErrorCode getErrorCode();
}
