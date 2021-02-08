package org.ayty.hatcher.api.v1.profile.exception.handling;

import javax.servlet.http.HttpServletRequest;

import org.ayty.hatcher.api.v1.profile.exception.handling.ProfileStandardError;
import org.ayty.hatcher.api.v1.profile.exception.NotFoundException;
import org.ayty.hatcher.api.v1.profile.exception.AlreadyExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ProfileExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> profileNotFound(NotFoundException exception, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ProfileStandardError error = new ProfileStandardError(System.currentTimeMillis(),status.value(),exception.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> profileAlreadyExists (AlreadyExistsException exception, HttpServletRequest request){
		HttpStatus status = HttpStatus.CONFLICT;
		ProfileStandardError error = new ProfileStandardError(System.currentTimeMillis(),status.value(),exception.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
}