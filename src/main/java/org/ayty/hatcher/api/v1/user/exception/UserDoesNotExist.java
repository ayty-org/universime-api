package org.ayty.hatcher.api.v1.user.exception;

public class UserDoesNotExist extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	
	public UserDoesNotExist(String msg) {
		super(msg);
	}
	public UserDoesNotExist() {
		super();
	}

}
