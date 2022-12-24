package com.example.drivinglicense.service;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drivinglicense.constants.CustomErrors;
import com.example.drivinglicense.dto.ApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicationResponseDTO;
import com.example.drivinglicense.mapper.ApplicationMapper;
import com.example.drivinglicense.model.Applicant;
import com.example.drivinglicense.model.Application;
import com.example.drivinglicense.repository.ApplicantRepository;
import com.example.drivinglicense.repository.ApplicationRepository;
import com.example.drivinglicense.utility.EnumUtility;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	ApplicantRepository applicantRepository;
	
	@Autowired
	CustomErrors errors;
	
	private final ApplicationMapper applicationMapper = Mappers.getMapper(ApplicationMapper.class);
	
	@Override
	public ApplicationResponseDTO createApplication(ApplicationRequestDTO request) {
		
		System.out.println("Create application is triggered");
		
		Application newApplication = applicationMapper.getApplication(request, EnumUtility.Status.SUBMITTED.getStatus());
		
		Optional<Applicant> applicant = applicantRepository.findByEmail(request.getApplicantEmail());
		
		if(applicant.isEmpty()) {
			System.out.println("Applicant is null");
			return applicationMapper.getApplicationErrorResponse(errors.applicantNotFound());
		}
		
		newApplication.setApplicant(applicant.get());
		
		Application application = applicationRepository.save(newApplication);
		
		String identifier = String.format("%06d", application.getId());
		
		String applicationNumber = application.getCategory() + application.getType() + identifier;
		
		application.setApplicationNumber(applicationNumber);
		
		System.out.println("Saving application");
		
		application = applicationRepository.save(application);
		
		return applicationMapper.getApplicationResponse(application);
	}
	
	@Override
	public ApplicationResponseDTO getApplication(String email) {
		
		Optional<Application> application = applicationRepository.getApplicationByEmail(email);
		
		if(application.isEmpty()) {
			return applicationMapper.getApplicationErrorResponse(errors.applicationNotFound());
		}
		
		return applicationMapper.getApplicationResponse(application.get());
	}

}
