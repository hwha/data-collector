package com.hl.dc.artsy.exception;

public class FailedCreateStorageException extends RuntimeException {
    public FailedCreateStorageException(Throwable throwable) {
        super(throwable);
    }
}
