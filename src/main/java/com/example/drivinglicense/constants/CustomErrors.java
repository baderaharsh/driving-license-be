package com.example.drivinglicense.constants;

import org.springframework.stereotype.Component;

import com.example.drivinglicense.dto.ResponseError;

@Component
public class CustomErrors {
	
	private String code;
	private String message;
	
	public final ResponseError emailAlreadyUsed() {
		return new ResponseError("BAD REQUEST","Email is already used");
	}
	
	public final ResponseError applicantNotFound() {
		return new ResponseError("BAD REQUEST", "Applicant not found");
	}
}
