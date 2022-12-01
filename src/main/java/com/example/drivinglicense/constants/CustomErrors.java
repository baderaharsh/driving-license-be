package com.example.drivinglicense.constants;

import org.springframework.stereotype.Component;

import com.example.drivinglicense.dto.ResponseError;

@Component
public class CustomErrors {
	
	private String code;
	private String message;
	
	public final ResponseError emailAlreadyExist() {
		return new ResponseError("BAD REQUEST","Email already exists");
	}
}
