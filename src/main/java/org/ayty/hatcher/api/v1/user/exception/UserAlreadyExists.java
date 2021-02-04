package org.ayty.hatcher.api.v1.user.exception;

public class UserAlreadyExists extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public UserAlreadyExists(String msg) {
		super(msg);
	}
	
	public UserAlreadyExists() {
		super();
	}
	

}
