package com.example.exception;

public class ApplicationExceptionsNotFound extends Exception {
    private static final long serialVersionUID = 1L;

    public ApplicationExceptionsNotFound(String message) {
        super(message);
    }

    public ApplicationExceptionsNotFound(String message, Throwable throwable) {
        super(message, throwable);
    }
}
