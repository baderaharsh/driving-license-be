package com.example.drivinglicense.constants;

import org.springframework.stereotype.Component;

import com.example.drivinglicense.dto.ResponseError;

@Component
public class CustomErrors {
	
	public final ResponseError emailAlreadyUsed() {
		return new ResponseError("EMAIL_ALREADY_EXIST","Email is already used");
	}
	
	public final ResponseError applicantNotFound() {
		return new ResponseError("APPLICANT_NOT_FOUND", "Applicant not found");
	}
	
	public final ResponseError applicationNotFound() {
		return new ResponseError("APPLICATION_NOT_FOUND", "Application not found");
	}
}
