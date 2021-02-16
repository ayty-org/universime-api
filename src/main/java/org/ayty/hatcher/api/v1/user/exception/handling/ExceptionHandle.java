package org.ayty.hatcher.api.v1.user.exception.handling;

import javax.servlet.http.HttpServletRequest;

import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPasswordException;
import org.ayty.hatcher.api.v1.user.exception.InvalidDataException;
import org.ayty.hatcher.api.v1.user.exception.InvalidTokenException;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFoundException;
import org.ayty.hatcher.api.v1.user.exception.UserAlreadyExistsException;
import org.ayty.hatcher.api.v1.user.exception.UserDoesNotExistException;
import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(IncorrectUserOrPasswordException.class)
	public ResponseEntity<StandardError> incorrectUserOrPasswordHandle(IncorrectUserOrPasswordException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Invalid",
				"Incorrec User Or Password", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(LoginNotFoundException.class)
	public ResponseEntity<StandardError> loginNotFoundHandle(LoginNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found",
				"Login Not Found", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<StandardError> userAlreadyExistHandle(UserAlreadyExistsException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Conflict",
				"User Already Exists", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<StandardError> invalidDataHandle(InvalidDataException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Valid Data",
				"Data is invalid", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(UserDoesNotExistException.class)
	public ResponseEntity<StandardError> userDoesNotExistHandle(UserDoesNotExistException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "User Not found",
				"User Does Not Exist", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<StandardError> invalidTokenHandle(InvalidTokenException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "UNAUTHORIZED",
				"token is invalid", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<StandardError> usernameNotFoundExceptionHandle(UsernameNotFoundException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found",
				"Username Not Found Exception", request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
