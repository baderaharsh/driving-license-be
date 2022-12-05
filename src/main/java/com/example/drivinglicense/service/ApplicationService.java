package com.example.drivinglicense.service;

import com.example.drivinglicense.dto.ApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicationResponse;

public interface ApplicationService {
	public ApplicationResponse createApplication(ApplicationRequestDTO application);
}
