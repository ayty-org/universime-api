package org.ayty.hatcher.api.v1.user.exception.handling;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPassword;
import org.ayty.hatcher.api.v1.user.exception.InvalidData;
import org.ayty.hatcher.api.v1.user.exception.InvalidToken;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFound;
import org.ayty.hatcher.api.v1.user.exception.UserAlreadyExists;
import org.ayty.hatcher.api.v1.user.exception.UserDoesNotExist;
import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(IncorrectUserOrPassword.class)
	public ResponseEntity<StandardError> IncorrectUserOrPasswordHandle(IncorrectUserOrPassword e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Invalid",
				"Incorrec User Or Password", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(LoginNotFound.class)
	public ResponseEntity<StandardError> LoginNotFoundHandle(LoginNotFound e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found",
				"Login Not Found", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<StandardError> UserAlreadyExistHandle(UserAlreadyExists e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Conflict",
				"User Already Exists", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(InvalidData.class)
	public ResponseEntity<StandardError> InvalidDataHandle(InvalidData e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Valid Data",
				"Data is invalid", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(UserDoesNotExist.class)
	public ResponseEntity<StandardError> UserDoesNotExistHandle(UserDoesNotExist e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "User Not found",
				"User Does Not Exist", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(InvalidToken.class)
	public ResponseEntity<StandardError> InvalidTokenHandle(InvalidToken e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "UNAUTHORIZED",
				"token is invalid", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<StandardError> UsernameNotFoundExceptionHandle(UsernameNotFoundException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found",
				"Username Not Found Exception", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
