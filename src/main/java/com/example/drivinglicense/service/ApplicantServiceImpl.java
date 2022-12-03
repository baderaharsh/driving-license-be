package com.example.drivinglicense.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
				return applicantMapper.getErrorResponse(errors.applicantNotFound());
			} else {
				return applicantMapper.getApplicantResponseDTO(applicant.get());
			}
		} catch (Exception ex) {
			log.error("Something went wrong!");
		}
		
		return null;
	}

	@Override
	public ApplicantResponseDTO createApplicant(ApplicantRequestDTO applicantDTO) {

		try {

			if (!findApplicant(applicantDTO.getEmail()).isEmpty()) {
				return applicantMapper.getErrorResponse(errors.emailAlreadyUsed());
			}

			Applicant applicant = applicantMapper.getApplicant(applicantDTO);

			applicantRepository.save(applicant);
			
			return applicantMapper.getApplicantResponseDTO(applicant);

		} catch (Exception e) {

			log.error("Exception occured while creating applicant");

		}
		
		return null;
	}
	
	@Override
	public ApplicantResponseDTO updateApplicant(ApplicantRequestDTO applicantDTO) {

		try {
			
			Optional<Applicant> applicantToBeUpdated = findApplicant(applicantDTO.getEmail());

			if (applicantToBeUpdated.isEmpty() || !applicantToBeUpdated.get().isActive()) {
				return applicantMapper.getErrorResponse(errors.applicantNotFound());
			}

			Applicant applicant = applicantMapper.getUpdatedApplicant(applicantToBeUpdated.get(), applicantDTO);

			applicantRepository.save(applicant);
			
			return applicantMapper.getApplicantResponseDTO(applicant);

		} catch (Exception e) {

			log.error("Exception occured while creating applicant");

		}
		
		return null;
	}
	
	@Override
	public ApplicantWithApplicationResponseDTO createApplicantWithApplication(ApplicantWithApplicationRequestDTO request) {
		 return null;
	}
	
	@Override
	public String removeApplicant(String email) {
		
		try {
			
			Optional<Applicant> applicant = findApplicant(email);
			
			if(applicant.isEmpty()) {
				return errors.applicantNotFound().getMessage();
			} else {
				applicant.get().setActive(false);
			}
			
		} catch (Exception e) {

			log.error("Exception occured while creating applicant");

		}
		
		return null;
	}

	public List<ApplicantRequestDTO> getApplicantsWithoutDocNum() {

		ApplicantMapper mapper = Mappers.getMapper(ApplicantMapper.class);

		List<Applicant> applicants = applicantRepository.findByDocumentNumberOrDocumentNumber("", null);

		System.out.println("Applicants are : " + applicants);

		List<ApplicantRequestDTO> applicantDTO = applicants.stream().map(applicant -> mapper.getApplicantDTO(applicant))
				.collect(Collectors.toList());

		return applicantDTO;
	}

}
