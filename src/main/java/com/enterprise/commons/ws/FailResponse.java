package com.enterprise.commons.ws;

import lombok.EqualsAndHashCode;
import lombok.Getter;



@Getter
@EqualsAndHashCode(callSuper = true)
public class FailResponse extends AbstractResponse {

	private static final long serialVersionUID = 8693802945900291448L;

	private final Long code;
	private final String message;

	public FailResponse(Long code, String message) {
		this.code = code;
		this.message = message;
	}

}
