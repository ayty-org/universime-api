package org.ayty.hatcher.api.v1.user.exception;

public class IncorrectUserOrPassword extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public IncorrectUserOrPassword(String msg) {
		super(msg);
	}
	
	public IncorrectUserOrPassword() {
		super();
	}
	
	

}
