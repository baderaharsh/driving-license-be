package com.example.drivinglicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.drivinglicense.dto.ApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicationResponseDTO;
import com.example.drivinglicense.service.ApplicationService;

@RestController
@RequestMapping("/application")
public class DrivingLicenseApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@PostMapping("/create")
	public void createApplication(@RequestBody ApplicationRequestDTO request) {
		applicationService.createApplication(request);
	}
	
	@GetMapping
	public ApplicationResponseDTO getApplication(@RequestParam String email) {
		return applicationService.getApplication(email);
	}
}
