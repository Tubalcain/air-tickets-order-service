package com.example.airticketsorderservice.common;

import com.example.airticketsorderservice.common.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(BaseUnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResult handleUnauthorizedException(BaseUnauthorizedException e) {
        return ErrorResult.builder()
                          .errorCode(e.getErrorCode().value())
                          .message(e.getMessage())
                          .build();
    }

    @ExceptionHandler(BaseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResult handleNotFoundException(BaseNotFoundException e) {
        return ErrorResult.builder()
                          .errorCode(e.getErrorCode().value())
                          .message(e.getMessage())
                          .build();
    }

    @ExceptionHandler(BaseConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResult handleBaseConflictException(BaseConflictException e) {
        return ErrorResult.builder()
                          .errorCode(e.getErrorCode().value())
                          .message(e.getMessage())
                          .build();
    }

    @ExceptionHandler(BaseInternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResult handleBaseInternalServerException(BaseInternalServerException e) {
        return ErrorResult.builder()
                          .errorCode(e.getErrorCode().value())
                          .message(e.getMessage())
                          .build();
    }
}
