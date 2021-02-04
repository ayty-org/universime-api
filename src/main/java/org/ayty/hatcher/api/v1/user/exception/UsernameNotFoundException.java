package org.ayty.hatcher.api.v1.user.exception;

public class UsernameNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public UsernameNotFoundException(String msg) {
		super(msg);
	}
	public UsernameNotFoundException() {
		super();
	}

}
