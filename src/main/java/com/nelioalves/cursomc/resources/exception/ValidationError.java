package com.nelioalves.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StardardError {


	private static final long serialVersionUID = -8594692900395987251L;

	private List<FieldMessage> errors;
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		this.errors = new ArrayList<FieldMessage>();
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
}
