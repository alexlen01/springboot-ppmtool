package com.local.ppmtool.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class MapValidationErrorService {

	// Validate the request body, and provide the custom error message.
	public ResponseEntity<?> checkForErrors(BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for (FieldError error: result.getFieldErrors()) {
				// Customized JSON response	(displaying "field" and "defaultMessage")
				errorMap.put(error.getField(), error.getDefaultMessage());
			}

			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		return null;
	}
}