package com.example.drivinglicense.service;

import com.example.drivinglicense.dto.ApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicationResponseDTO;

public interface ApplicationService {
	public ApplicationResponseDTO createApplication(ApplicationRequestDTO application);
	public ApplicationResponseDTO getApplication(String email);
}
