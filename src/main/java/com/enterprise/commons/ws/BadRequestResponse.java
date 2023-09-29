package com.enterprise.commons.ws;

import java.util.Collection;
import java.util.Map;

public class BadRequestResponse extends FailResponse {

	private final Collection<ErrorWrapper> errors;

	public BadRequestResponse(Long code, String message, Collection<ErrorWrapper> errors) {
		super(code, message);
		this.errors = errors;
	}

	public Collection<ErrorWrapper> getErrors() {
		return errors;
	}
}
