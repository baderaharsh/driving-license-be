package com.example.drivinglicense.service;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drivinglicense.constants.CustomErrors;
import com.example.drivinglicense.dto.ApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicationResponse;
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
	public ApplicationResponse createApplication(ApplicationRequestDTO request) {
		
		Application newApplication = applicationMapper.getApplication(request, EnumUtility.Status.SUBMITTED.getStatus());
		
		Optional<Applicant> applicant = applicantRepository.findByEmail(request.getApplicantEmail());
		
		if(applicant.isEmpty()) {
			return applicationMapper.getApplicationErrorResponse(errors.applicantNotFound());
		}
		
		newApplication.setApplicant(applicant.get());
		
		Application application = applicationRepository.save(newApplication);
		
		String identifier = String.format("%06d", application.getId());
		
		String applicationNumber = application.getCategory() + application.getType() + identifier;
		
		application.setApplicationNumber(applicationNumber);
		
		application = applicationRepository.save(application);
		
		return applicationMapper.getApplicationResponse(application);
	}
	
	@Override
	public ApplicationResponse getApplication(String email) {
		
		Optional<Application> application = applicationRepository.getApplicationByEmail(email);
		
		if(application.isEmpty()) {
			return applicationMapper.getApplicationErrorResponse(errors.applicationNotFound());
		}
		
		return applicationMapper.getApplicationResponse(application.get());
	}

}
