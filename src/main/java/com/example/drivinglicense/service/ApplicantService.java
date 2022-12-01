package com.example.drivinglicense.service;

import com.example.drivinglicense.dto.ApplicantResponseDTO;
import com.example.drivinglicense.dto.ApplicantRequestDTO;
import com.example.drivinglicense.dto.ApplicantWithApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicantWithApplicationResponseDTO;

public interface ApplicantService {
	public ApplicantResponseDTO createApplicant(ApplicantRequestDTO request);
	public ApplicantResponseDTO getApplicant(String email);
	public ApplicantResponseDTO updateApplicant(ApplicantRequestDTO request);
	public ApplicantWithApplicationResponseDTO createApplicantWithApplication(ApplicantWithApplicationRequestDTO request);
	public String removeApplicant(String email);
}
