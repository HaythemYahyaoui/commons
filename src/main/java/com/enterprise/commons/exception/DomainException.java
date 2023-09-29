package com.enterprise.commons.exception;

public class DomainException extends Exception {

    private final IError error;

    public DomainException(IError error) {
        this.error = error;
    }

    public DomainException(Throwable cause, IError error) {
        super(cause);
        this.error = error;
    }

    public IError getError() {
        return error;
    }

}
