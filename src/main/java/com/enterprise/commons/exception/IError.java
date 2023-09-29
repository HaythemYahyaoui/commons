package com.enterprise.commons.exception;

import java.io.Serializable;

public interface IError extends Serializable {

    Integer getStatus();

    Long getCode();

    String getMessage();

}
