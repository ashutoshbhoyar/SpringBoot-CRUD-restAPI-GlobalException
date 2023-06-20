package com.example.demo.CustomException;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;

}
