package com.enterprise.commons.exception;

public class InfrastructureException extends Exception {

    private final IError error;

    public InfrastructureException(IError error) {
        this.error = error;
    }

    public InfrastructureException(Throwable cause, IError error) {
        super(cause);
        this.error = error;
    }

    public IError getError() {
        return error;
    }

}
