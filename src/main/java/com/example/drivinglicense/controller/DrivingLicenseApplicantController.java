package com.example.drivinglicense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.drivinglicense.dto.ApplicantRequestDTO;
import com.example.drivinglicense.dto.ApplicantResponseDTO;
import com.example.drivinglicense.dto.ApplicantWithApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicantWithApplicationResponseDTO;
import com.example.drivinglicense.service.ApplicantService;

@RestController
@RequestMapping("/applicant")
public class DrivingLicenseApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	//Get last n created users
	@GetMapping()
	public List<ApplicantRequestDTO> getApplicants(Integer n){
		return null;
	}
	
	//Get user using their email
	@GetMapping("/{email}")
	public Object getApplicant(@PathVariable String email) {
		return applicantService.getApplicant(email);
	}
	
	//Create applicant
	@PostMapping()
	public ApplicantResponseDTO createApplicant(@RequestBody ApplicantRequestDTO applicantDTO) {
		return applicantService.createApplicant(applicantDTO);
	}
	
	//Update applicant
	@PatchMapping("/update-applincat")
	public ApplicantResponseDTO updateApplicant(@RequestBody ApplicantRequestDTO applicantDTO) {
		return applicantService.updateApplicant(applicantDTO);
		
	}
	
	//Create application for applicant
	@PostMapping("/applicant/application")
	public ApplicantWithApplicationResponseDTO submitApplicantWithApplication(@RequestBody ApplicantWithApplicationRequestDTO request) {
		return applicantService.createApplicantWithApplication(request);
	}
	
	@DeleteMapping("/remove/{email}")
	public String deleteApplicant(@PathVariable String email) {
		return applicantService.removeApplicant(email);
	}
}
