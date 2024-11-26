package com.crud_lombok_exception_mongo_java8.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex) {
		Map<String, Object> errorBody = new HashMap<String, Object>();

		errorBody.put("Message", "Unexcepted Error Occur");
		errorBody.put("Timestamp", LocalDate.now());
		errorBody.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorBody.put("Detail", ex.getMessage());

		return new ResponseEntity<Map<String, Object>>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		Map<String, Object> errorbody = new HashMap<String, Object>();

		errorbody.put("Message", "Resource Not Found");
		errorbody.put("Timestamp", LocalDate.now());
		errorbody.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorbody.put("Detail", ex.getMessage());

		return new ResponseEntity<Map<String, Object>>(errorbody, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
