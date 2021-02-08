package org.ayty.hatcher.api.v1.user.exception.handling;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
	
	private List<String> erros;
	
	public ApiErrors(String msg) {
		this.erros = Arrays.asList(msg);
	}
	public ApiErrors(List<String> msg) {
		this.erros = msg;
	}
	

	public ApiErrors() {
		super();
		
	}


	public List<String> getErros() {
		return erros;
	}

	
	

}