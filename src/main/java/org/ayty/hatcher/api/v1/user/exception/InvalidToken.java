package org.ayty.hatcher.api.v1.user.exception;

public class InvalidToken extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	
	public InvalidToken(String msg) {
		super(msg);
	}
	public InvalidToken() {
		super();
	}

}
