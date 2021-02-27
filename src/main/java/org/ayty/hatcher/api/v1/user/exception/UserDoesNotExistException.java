package org.ayty.hatcher.api.v1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDoesNotExistException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UserDoesNotExistException(String msg) {
		super(msg);
	}
	public UserDoesNotExistException() {
		super();
	}
}
