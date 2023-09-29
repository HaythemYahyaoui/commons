package com.enterprise.commons.ws;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;


@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class AbstractResponse implements Serializable {

	private static final long serialVersionUID = 4758741729185517100L;

	@EqualsAndHashCode.Include
	private final String id;

	public AbstractResponse() {
		super();
		this.id = UUID.randomUUID().toString();
	}

}
