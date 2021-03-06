package com.nelioalves.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.nelioalves.cursomc.services.exception.AuthorizationException;
import com.nelioalves.cursomc.services.exception.DataIntegrityException;
import com.nelioalves.cursomc.services.exception.FileException;
import com.nelioalves.cursomc.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StardardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){		
		StardardError err = new StardardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);	
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StardardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
		StardardError err = new StardardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", e.getMessage(), request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StardardError> dataIntegrity(MethodArgumentNotValidException e, HttpServletRequest request){
		
		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", e.getMessage(), request.getRequestURI());		
		
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StardardError> authorization(AuthorizationException e, HttpServletRequest request){
		
		StardardError err = new StardardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso negado", e.getMessage(), request.getRequestURI());		
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	
	}
	
	@ExceptionHandler(FileException.class)
	public ResponseEntity<StardardError> file(FileException e, HttpServletRequest request){
		
		StardardError err = new StardardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso negado", e.getMessage(), request.getRequestURI());		
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	
	}
	
	@ExceptionHandler(AmazonServiceException.class)
	public ResponseEntity<StardardError> amazonService(AmazonServiceException e, HttpServletRequest request){
		
		HttpStatus code = HttpStatus.valueOf(e.getErrorCode());
		
		StardardError err = new StardardError(System.currentTimeMillis(), code.value(), "Erro Amazon Service", e.getMessage(), request.getRequestURI());	
		
		return ResponseEntity.status(code.value()).body(err);
	
	}
	
	@ExceptionHandler(AmazonClientException.class)
	public ResponseEntity<StardardError> amazonClient(AmazonClientException e, HttpServletRequest request){
		
		StardardError err = new StardardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro Amazon Client", e.getMessage(), request.getRequestURI());	
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	
	}
	
	@ExceptionHandler(AmazonS3Exception.class)
	public ResponseEntity<StardardError> amazonS3(AmazonS3Exception e, HttpServletRequest request){
		
		StardardError err = new StardardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro S3", e.getMessage(), request.getRequestURI());	
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	
	}

}
