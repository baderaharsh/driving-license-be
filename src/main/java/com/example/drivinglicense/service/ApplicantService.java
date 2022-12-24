package com.example.drivinglicense.service;

import com.example.drivinglicense.dto.ApplicantResponseDTO;
import com.example.drivinglicense.dto.ApplicantWithApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicantWithApplicationResponseDTO;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.drivinglicense.dto.ApplicantRequestDTO;

public interface ApplicantService {
	public ApplicantWithApplicationResponseDTO createApplicant(@RequestBody ApplicantWithApplicationRequestDTO applicantDTO);
	public ApplicantResponseDTO getApplicant(String email);
	public ApplicantResponseDTO updateApplicant(ApplicantRequestDTO request);
	public String removeApplicant(String email);
}
