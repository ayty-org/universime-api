package org.ayty.hatcher.api.v1.competence.exception;

public class CompetenceNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CompetenceNotFound() {
		super("Competência não encontrada");
	}
	
}
