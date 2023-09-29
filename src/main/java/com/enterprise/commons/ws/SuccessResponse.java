package com.enterprise.commons.ws;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@EqualsAndHashCode(callSuper = true)
public class SuccessResponse extends AbstractResponse {

	private static final long serialVersionUID = 8693802945900291448L;

	private final Serializable data;

	public SuccessResponse(Serializable data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

}
