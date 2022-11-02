package com.example.exception;

public class ExceptionsMenuNotFound extends Exception {
    private static final long serialVersionUID = 1L;

    public ExceptionsMenuNotFound(String message) {
        super(message);
    }

    public ExceptionsMenuNotFound(String message, Throwable throwable) {
        super(message, throwable);
    }
}
