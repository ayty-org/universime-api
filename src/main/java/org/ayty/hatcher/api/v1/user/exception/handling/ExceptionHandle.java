package org.ayty.hatcher.api.v1.user.exception.handling;

import javax.servlet.http.HttpServletRequest;

import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPassword;
import org.ayty.hatcher.api.v1.user.exception.InvalidData;
import org.ayty.hatcher.api.v1.user.exception.InvalidPasswordException;
import org.ayty.hatcher.api.v1.user.exception.InvalidToken;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFound;
import org.ayty.hatcher.api.v1.user.exception.UserAlreadyExists;
import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(IncorrectUserOrPassword.class)
	public ResponseEntity<StandardError> IncorrectUserOrPasswordHandle(IncorrectUserOrPassword e,HttpServletRequest request){
		HttpStatus status = HttpStatus.FORBIDDEN;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Access denied", "login or password is incorrect :(", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<StandardError> InvalidPasswordHandle(InvalidPasswordException e,HttpServletRequest request){
		HttpStatus status = HttpStatus.FORBIDDEN;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Access denied", "password is incorrect :(", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(InvalidToken.class)
	public ResponseEntity<StandardError> InvalidTokenHandle(InvalidToken e,HttpServletRequest request){
		HttpStatus status = HttpStatus.FORBIDDEN;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Access denied", "invalid token :(", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(LoginNotFound.class)
	public ResponseEntity<StandardError> LoginNotFoundHandle(LoginNotFound e,HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Access denied", "login not found :(", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<StandardError> UserAlreadyExistHandle(UserAlreadyExists e,HttpServletRequest request){
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Conflit", "User Already Exists :(", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<StandardError> UsernameNotFoundHandle(UsernameNotFoundException e,HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", "Username Not Found :(", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(InvalidData.class)
	public ResponseEntity<StandardError> InvalidDataHandle(InvalidData e,HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "BAD REQUEST", "Invalid data  :(", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
