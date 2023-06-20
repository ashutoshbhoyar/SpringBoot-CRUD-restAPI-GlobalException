package com.example.demo.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFound extends Exception {
	public ResourseNotFound(String message) {
		super(message);
	}
}