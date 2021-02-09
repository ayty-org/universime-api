package org.ayty.hatcher.api.v1.competence.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handleFieldValidation(MethodArgumentNotValidException ex) {
		
		List<String> errorsList = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
	
		ErrorDetails ed = ErrorDetails.builder()
				.code(HttpStatus.BAD_REQUEST.toString())
				.message("Erro de Validação")
				.errors(errorsList)
				.build();
		
		return new ResponseEntity(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CompetenceNotFound.class)
	public ResponseEntity competenceNotFound(CompetenceNotFound ex) {
	
		ErrorDetails ed = ErrorDetails.builder()
				.code(HttpStatus.NOT_FOUND.toString())
				.message("Erro ao pesquisar elemento")
				.errors(Arrays.asList(ex.getMessage()))
				.build();
		
		return new ResponseEntity(ed, HttpStatus.NOT_FOUND);
	}
}
