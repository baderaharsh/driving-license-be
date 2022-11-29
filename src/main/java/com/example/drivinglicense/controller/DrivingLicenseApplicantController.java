package com.example.drivinglicense.controller;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.drivinglicense.dto.ApplicantDTO;
import com.example.drivinglicense.model.RequestDTO;
import com.example.drivinglicense.service.ApplicantServiceImpl;

@RestController
@RequestMapping("/applicant")
public class DrivingLicenseApplicantController {
	
	@Autowired
	ApplicantServiceImpl applicantService;
	
	//Get last n created users
	@GetMapping()
	public List<ApplicantDTO> getApplicants(Integer n){
		return null;
	}
	
	//Get user using their email
	@GetMapping("/{email}")
	public Object getApplicant(@PathVariable String email) {
		return applicantService.getApplicant(email);
	}
	
	//Create applicant
	@PostMapping()
	public String createApplicant(@RequestBody ApplicantDTO applicantDTO) {
		return applicantService.createApplicant(applicantDTO);
	}
	
	//Update applicant
	@PatchMapping("/update-applincat")
	public ApplicantDTO updateApplicant(@RequestBody ApplicantDTO applicantDTO) {
		return applicantService.updateApplicant(applicantDTO);
		
	}
	
	//Create application for applicant
	@PostMapping("/application")
	public void submitApplicantWithApplication(@RequestBody RequestDTO request) {
		applicantService.submit(request);
	}
	
	@DeleteMapping("/remove/{email}")
	public void deleteApplicant(@PathVariable String email) {
	
	}
}
