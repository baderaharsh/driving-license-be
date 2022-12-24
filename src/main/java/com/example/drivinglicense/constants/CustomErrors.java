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
	
	public final ResponseError applicantIsNull() {
		return new ResponseError("EMPTY_APPLICANT", "Applicant information not provided");
	}
	
	public final ResponseError nameCannotBeNull() {
		return new ResponseError("INVALID_NAME", "First name or last name cannot be null");
	}
	
	public final ResponseError duplicatePhone() {
		return new ResponseError("DUPLICATE_PHONE", "Phone number is already used by another account");
	}
	
	public final ResponseError underAge() {
		return new ResponseError("INELIGIBLE", "Age must be 18 or above");
	}
	
	public final ResponseError emptyDocDetails() {
		return new ResponseError("EMPTY_DOC_DETAILS", "Document type or document number cannot be null");
	}
	
	public final ResponseError emptyDob() {
		return new ResponseError("EMPTY_DOB", "Date of birth cannot be null");
	}
}
