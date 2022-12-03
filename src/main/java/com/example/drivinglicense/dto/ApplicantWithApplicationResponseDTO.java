package com.example.drivinglicense.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class ApplicantWithApplicationResponseDTO {
	ApplicantResponse applicant;
	ApplicationResponse application;
	ResponseError error;
}
