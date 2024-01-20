package com.stallion.serviceterminus.error;

import org.springframework.http.HttpStatus;

public class GenericException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public GenericException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
