package org.ayty.hatcher.api.v1.user.exception;

public class InvalidPasswordException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidPasswordException(String msg) {
		super(msg);
	}
	public InvalidPasswordException() {
		super();
	}

}
