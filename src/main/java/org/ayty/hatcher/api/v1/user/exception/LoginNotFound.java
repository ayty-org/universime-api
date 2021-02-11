package org.ayty.hatcher.api.v1.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoginNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LoginNotFound(String msg) {
		super(msg);
	}

	public LoginNotFound() {
		super();
	}
}
