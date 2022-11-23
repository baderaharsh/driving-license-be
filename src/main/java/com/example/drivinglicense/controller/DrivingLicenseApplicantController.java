package com.example.drivinglicense.controller;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.drivinglicense.dto.ApplicantDTO;
import com.example.drivinglicense.mapper.ApplicantMapper;
import com.example.drivinglicense.model.Applicant;
import com.example.drivinglicense.model.RequestDTO;
import com.example.drivinglicense.repository.ApplicationRepository;
import com.example.drivinglicense.service.ApplicantService;

@RestController
@RequestMapping("/applicant")
public class DrivingLicenseApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	@GetMapping()
	public ApplicantDTO getApplicant(@RequestParam String email) {
		System.out.println("Triggered with param email : " + email);
		return applicantService.getApplicant(email);
	}
	
	@GetMapping("/query")
	public Applicant getApplicantFP(@RequestParam String firstName, @RequestParam Long phone, @RequestParam String email) {
		System.out.println("Triggered with param : " + firstName + " " + phone);
		return applicantService.getApplicantFP(firstName, phone,email);
	}
	
	@PostMapping()
	public String createApplicant(@RequestBody ApplicantDTO applicantDTO) {
		ApplicantMapper mapper = Mappers.getMapper(ApplicantMapper.class);
		
		Applicant newApplicant = mapper.getApplicant(applicantDTO);
		return applicantService.createApplicant(newApplicant);
	}
	
	@PatchMapping("/update-applincat")
	public ApplicantDTO updateApplicant(@RequestBody ApplicantDTO applicantDTO) {
		return applicantService.updateApplicant(applicantDTO);
		
	}
	
	@GetMapping("/pending-document-number")
	public List<ApplicantDTO> getApplicantsWithoutDocumentNumber(){
		return applicantService.getApplicantsWithoutDocNum();
	}
	
	@PostMapping("/application")
	public void submitApplicantWithApplication(@RequestBody RequestDTO request) {
		
		applicantService.submit(request);
		
	}
}
