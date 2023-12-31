package com.example.demo.CustomException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	public ResponseEntity<?> resourceNotFoundException(ResourseNotFound notFound, WebRequest request) {

		ErrorDetails details = new ErrorDetails(new Date(), notFound.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);

	}

}
