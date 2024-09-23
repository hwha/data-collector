package com.hl.dc.artsy.exception;

public class FailedSaveFileException extends RuntimeException {
    public FailedSaveFileException(Throwable throwable) {
        super(throwable);
    }
}
