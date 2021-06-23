package com.example.demo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long seriavlVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
