package com.nelioalves.cursomc.resources.exception;

import java.util.List;

public class ValidationError extends StardardError {


	private static final long serialVersionUID = -8594692900395987251L;

	private List<FieldMessage> errors;

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
		this.errors = errors;
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
}
