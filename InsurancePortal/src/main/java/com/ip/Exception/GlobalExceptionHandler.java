package com.ip.Exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IPException.class)
	public ResponseEntity<ErrorInformation> ipException(IPException i) {
		ErrorInformation e = new ErrorInformation();
		e.setErrorMessage(i.getMessage());
		e.setStatusCode(HttpStatus.BAD_REQUEST.value());
		e.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInformation>(e, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException1(MethodArgumentNotValidException e) {
		ErrorInformation er = new ErrorInformation();
		er.setTimeStamp(LocalDateTime.now());
		er.setStatusCode(HttpStatus.BAD_REQUEST.value());

		String errorMessage = e.getBindingResult().getAllErrors().stream()
				.map((ObjectError e1) -> e1.getDefaultMessage()).collect(Collectors.joining(", "));
		er.setErrorMessage(errorMessage);

		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException c) {
		ErrorInformation er = new ErrorInformation();
		er.setTimeStamp(LocalDateTime.now());
		er.setStatusCode(HttpStatus.BAD_REQUEST.value());
		String string = c.getConstraintViolations().stream().map((e) -> e.getMessage())
				.collect(Collectors.joining(", "));
		er.setErrorMessage(string);
		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);

	}

	// Parent Class of all Exceptions to handle all Exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInformation> parentExceptionHandler(Exception e) {
		ErrorInformation er = new ErrorInformation();
		er.setErrorMessage(e.getMessage());
		er.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		er.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInformation>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
