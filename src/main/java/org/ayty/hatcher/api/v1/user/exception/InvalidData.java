package org.ayty.hatcher.api.v1.user.exception;

public class InvalidData extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidData(String msg) {
		super(msg);
	}
	
	public InvalidData() {
		super();
	}
	
	

}
