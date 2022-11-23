package com.example.drivinglicense.service;

import com.example.drivinglicense.dto.ApplicantDTO;

public interface ApplicantService {
	public String createApplicant(ApplicantDTO applicantDTO);
	public ApplicantDTO getApplicant(String email);
}
