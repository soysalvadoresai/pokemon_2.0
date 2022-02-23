package com.pokemon.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoUniqueNamesException.class)
	public ResponseEntity<ErrorDetails> handleResourceNoUniqueNamesException(NoUniqueNamesException exception, 
			WebRequest webrequest){
		ErrorDetails error = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), webrequest.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleResourceMethodArgumentNotValidException(MethodArgumentNotValidException exception, 
			WebRequest webrequest){
		ErrorDetails error = null;
		String message = "";
		if(exception.getMessage().contains("unique")) {
			message = " No debe repetir el pokemon en su equipo. ";
		}else {
			message = " Debe seleccionar al menos un pokemon, y un tipo.";
		}
		error = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR,message, webrequest.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorDetails> handleResourceBlogAPIException(APIException exception, 
			WebRequest webrequest){
		ErrorDetails error = new ErrorDetails(exception.getStatus(), exception.getMessage() , webrequest.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
