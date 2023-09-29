package com.enterprise.commons.exception;

public class PresentationException extends Exception {

    private final IError error;

    public PresentationException(IError error) {
        this.error = error;
    }

    public PresentationException(Throwable cause, IError error) {
        super(cause);
        this.error = error;
    }

    public IError getError() {
        return error;
    }

}
