package com.example.drivinglicense.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.drivinglicense.constants.CustomErrors;
import com.example.drivinglicense.dto.ApplicantRequestDTO;
import com.example.drivinglicense.dto.ApplicantResponseDTO;
import com.example.drivinglicense.dto.ApplicantWithApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicantWithApplicationResponseDTO;
import com.example.drivinglicense.mapper.ApplicantMapper;
import com.example.drivinglicense.model.Applicant;
import com.example.drivinglicense.repository.ApplicantRepository;
import com.example.drivinglicense.repository.ApplicationRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	ApplicantRepository applicantRepository;

	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	CustomErrors errors;

	private ApplicantMapper applicantMapper = Mappers.getMapper(ApplicantMapper.class);

	public Optional<Applicant> findApplicant(String email) {
		return applicantRepository.findByEmail(email);
	}

	@Override
	public ApplicantResponseDTO getApplicant(String email) {

		try {
			
			Optional<Applicant> applicant = findApplicant(email);
			
			if(applicant.isEmpty() || !applicant.get().isActive()) {
				log.warn("Applicant not found " + email);
				return applicantMapper.getApplicantErrorResponse(errors.applicantNotFound());
			} else {
				log.info(applicant.get());
				return applicantMapper.getApplicantResponseDTO(applicant.get());
			}
		} catch (Exception ex) {
			log.error("Something went wrong!");
		}
		
		return null;
	}

	@Override
	public ApplicantWithApplicationResponseDTO createApplicant(@RequestBody ApplicantWithApplicationRequestDTO request) {

		ApplicantWithApplicationResponseDTO response = new ApplicantWithApplicationResponseDTO();
		
		try {
			
			if(request.getApplicant() == null) {
				log.error("Applicant is null ");
				return applicantMapper.getErrorResponse(errors.applicantIsNull());
			}

			if (!findApplicant(request.getApplicant().getEmail()).isEmpty()) {
				log.error("Email already exist");
				return applicantMapper.getErrorResponse(errors.emailAlreadyUsed());
			}
			
			if (request.getApplicant().getFirstName().isBlank() || request.getApplicant().getLastName().isBlank()) {
				log.error("First or last name is not provided");
				return applicantMapper.getErrorResponse(errors.nameCannotBeNull());
			}
			
			if (request.getApplicant().getDob() == null) {
				log.error("Dob is not provided");
				return applicantMapper.getErrorResponse(errors.emailAlreadyUsed());
			}
			
			LocalDateTime dob = request.getApplicant().getDob();
			
			LocalDate dobInLocalDate = dob.toLocalDate();
			LocalDate nowInLocalDate = LocalDate.now();
			Period age = Period.between(dobInLocalDate, nowInLocalDate);
			
			if(age.getYears() < 18) {
				log.error("User is under 18");
				return applicantMapper.getErrorResponse(errors.underAge());
			}
			
			if (request.getApplicant().getDocumentType().isBlank() || request.getApplicant().getDocumentNumber().isBlank()) {
				log.error("Document type or document number is not provided");
				return applicantMapper.getErrorResponse(errors.emptyDocDetails());
			}

			Applicant applicant = applicantMapper.getApplicant(request.getApplicant());

			applicant = applicantRepository.save(applicant);
			
			log.info("Applicant is registered");
			
			response.setApplicant(applicantMapper.getApplicantResponse(applicant));
			
			if(request.getApplication() != null) {
				
				if(request.getApplication().getApplicantEmail() == null|| request.getApplication().getApplicantEmail().isBlank()) {
					request.getApplication().setApplicantEmail(applicant.getEmail());
				}
				
				response.setApplication(applicantMapper.getApplicationResponse(applicationService.createApplication(request.getApplication())));
				
				log.info("Application created");
				
			}else {
				log.warn("Applicant created without application");
			}
			
			
			
		} catch (Exception e) {

			log.error("Exception occured while creating applicant " + e.getMessage());

		}
		
		return response;
	}
	
	@Override
	public ApplicantResponseDTO updateApplicant(ApplicantRequestDTO applicantDTO) {

		try {
			
			Optional<Applicant> applicantToBeUpdated = findApplicant(applicantDTO.getEmail());

			if (applicantToBeUpdated.isEmpty() || !applicantToBeUpdated.get().isActive()) {
				log.error("Applicant not found");
				return applicantMapper.getApplicantErrorResponse(errors.applicantNotFound());
			}

			Applicant applicant = applicantMapper.getUpdatedApplicant(applicantToBeUpdated.get(), applicantDTO);

			applicantRepository.save(applicant);
			
			log.info("Applicant updated");
			
			return applicantMapper.getApplicantResponseDTO(applicant);

		} catch (Exception e) {

			log.error("Exception occured while creating applicant");

		}
		
		return null;
	}
	
	@Override
	public String removeApplicant(String email) {
		
		try {
			
			Optional<Applicant> applicant = findApplicant(email);
			
			if(applicant.isEmpty()) {
				log.error("Applicant not found");
				return errors.applicantNotFound().getMessage();
			} else {
				applicant.get().setActive(false);
				log.info("Applicant deactivated");
			}
			
		} catch (Exception e) {

			log.error("Exception occured while creating applicant");

		}
		
		return null;
	}

	public List<ApplicantRequestDTO> getApplicantsWithoutDocNum() {

		ApplicantMapper mapper = Mappers.getMapper(ApplicantMapper.class);

		List<Applicant> applicants = applicantRepository.findByDocumentNumberOrDocumentNumber("", null);

		log.info("Applicants are : " + applicants);

		List<ApplicantRequestDTO> applicantDTO = applicants.stream().map(applicant -> mapper.getApplicantDTO(applicant))
				.collect(Collectors.toList());

		return applicantDTO;
	}

}
