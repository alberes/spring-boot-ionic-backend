package com.nelioalves.cursomc.services.exception;

public class FileException extends RuntimeException{

	private static final long serialVersionUID = -5522390524720046893L;

	public FileException(String msg) {
		super(msg);
	}
	
	public FileException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
