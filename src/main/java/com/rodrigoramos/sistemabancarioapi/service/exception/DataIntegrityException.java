package com.rodrigoramos.sistemabancarioapi.service.exception;

public class DataIntegrityException extends RuntimeException {
    private static final long serialVersionUID = 4471777119419172870L;


    public DataIntegrityException(String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
