package com.nelioalves.cursomc.services.exception;

public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 2697418866384006091L;

	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
