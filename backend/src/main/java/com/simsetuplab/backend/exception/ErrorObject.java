package com.simsetuplab.backend.exception;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorObject {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;

	public ErrorObject(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}
}
