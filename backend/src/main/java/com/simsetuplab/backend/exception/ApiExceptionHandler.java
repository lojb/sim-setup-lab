package com.simsetuplab.backend.exception;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(ApiRequestException.class)
	public ResponseEntity<ErrorObject> handleApiRequestException(ApiRequestException exception, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		ErrorObject errorObject = new ErrorObject(
				exception.getMessage(),
				exception,
				status,
				ZonedDateTime.now()
		);

		return new ResponseEntity<>(errorObject, status);
	}
}
