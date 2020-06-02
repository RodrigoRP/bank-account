package com.rodrigoramos.sistemabancarioapi.service.exception;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 4471777119419172870L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
