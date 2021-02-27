package org.ayty.hatcher.api.v1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataException extends RuntimeException{	
	private static final long serialVersionUID = 1L;
	
	public InvalidDataException(String msg) {
		super(msg);
	}	
	public InvalidDataException() {
		super();
	}
}
