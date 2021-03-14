package org.ayty.hatcher.api.v1.competence.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CompetenceNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CompetenceNotFound() {
		super("Competência não encontrada");
	}
	
}
