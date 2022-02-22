package com.pokemon.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogAPIException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	//private String message = "";
	private HttpStatus status;
	private String message;
	public BlogAPIException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}
	public BlogAPIException(HttpStatus status, String message1) {
		super(message1);
		this.status = status;;
	}

}
