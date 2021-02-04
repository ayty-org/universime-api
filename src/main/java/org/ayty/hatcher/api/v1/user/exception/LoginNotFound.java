package org.ayty.hatcher.api.v1.user.exception;

public class LoginNotFound extends RuntimeException{
	
	 
	private static final long serialVersionUID = 1L;
	
	public LoginNotFound(String msg) {
		super(msg);
	}
	public LoginNotFound() {
		super();
	}
	

}
