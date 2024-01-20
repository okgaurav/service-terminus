package com.stallion.serviceterminus.error;

public class TerminusGenericException extends RuntimeException{

    public TerminusGenericException() {
    }

    public TerminusGenericException(String message) {
        super(message);
    }

    public TerminusGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
