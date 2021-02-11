package org.ayty.hatcher.api.v1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException{	
	private static final long serialVersionUID = 1L;
	
	public UsernameNotFoundException(String msg) {
		super(msg);
	}
	public UsernameNotFoundException() {
		super();
	}
}
