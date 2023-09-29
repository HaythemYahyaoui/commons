package com.enterprise.commons.ddd.repository;

import com.enterprise.commons.exception.IError;

public enum InfrastructureError implements IError {

    RESOURCE_NOT_FOUND(404, 0L, "Element not found");

    private Integer status;
    private Long code;
    private String message;

    InfrastructureError(Integer status, Long code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }


    public Integer getStatus() {
        return status;
    }

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

