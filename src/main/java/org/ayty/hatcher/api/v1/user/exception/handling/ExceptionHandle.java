package org.ayty.hatcher.api.v1.user.exception.handling;

import javax.servlet.http.HttpServletRequest;

import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPassword;
import org.ayty.hatcher.api.v1.user.exception.InvalidData;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFound;
import org.ayty.hatcher.api.v1.user.exception.UserAlreadyExists;
import org.ayty.hatcher.api.v1.user.exception.UserDoesNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(IncorrectUserOrPassword.class)
	public ResponseEntity<StandardError> IncorrectUserOrPasswordHandle(IncorrectUserOrPassword e,HttpServletRequest request){
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Access denied", "Incorrec User Or Password", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(LoginNotFound.class)
	public ResponseEntity<StandardError> LoginNotFoundHandle(LoginNotFound e,HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Access denied", "Login Not Found", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<StandardError> UserAlreadyExistHandle(UserAlreadyExists e,HttpServletRequest request){
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Conflict", "User Already Exists", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(InvalidData.class)
	public ResponseEntity<StandardError> InvalidDataHandle(InvalidData e,HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Valid Data", "Data is invalid", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(UserDoesNotExist.class)
	public ResponseEntity<StandardError> UserDoesNotExistHandle(UserDoesNotExist e,HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "User Not found", "User Does NotE xist", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	/*
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex) {
		List<String>errors = ex.getBindingResult().getAllErrors().stream().map(erro ->erro.getDefaultMessage()).collect(Collectors.toList());
	
		return new ApiErrors(errors);
	}
	 */
}
