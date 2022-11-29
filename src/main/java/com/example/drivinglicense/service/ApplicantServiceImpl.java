package com.example.drivinglicense.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.drivinglicense.dto.ApplicantDTO;
import com.example.drivinglicense.mapper.ApplicantMapper;
import com.example.drivinglicense.model.Applicant;
import com.example.drivinglicense.model.RequestDTO;
import com.example.drivinglicense.repository.ApplicantRepository;
import com.example.drivinglicense.repository.ApplicationRepository;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	ApplicantRepository applicantRepository;

	@Autowired
	ApplicationRepository applicationRepository;

	private ApplicantMapper mapper = Mappers.getMapper(ApplicantMapper.class);

	public Optional<Applicant> findApplicant(String email) {
		return applicantRepository.findByEmail(email);
	}

	@Override
	public ApplicantDTO getApplicant(String email) {

//		try {
//			
//			Optional<Applicant> applicant = findApplicant(email);
//			
//			if(!applicant.isEmpty()) {
//				return "User with email " + email + " does not exists";
//			} else {
//				return applicant.get();
//			}
//		}

		return null;
	}

	@Override
	public String createApplicant(ApplicantDTO applicantDTO) {

		try {

			if (!findApplicant(applicantDTO.getEmail()).isEmpty()) {
				return "Email already exists";
			}

			Applicant applicant = mapper.getApplicant(applicantDTO);

			applicantRepository.save(applicant);
			return "SUCCESS";

		} catch (Exception e) {

			return "Something went wrong!";

		}
	}

	public ApplicantDTO updateApplicant(ApplicantDTO applicantDTO) {

		ApplicantMapper mapper = Mappers.getMapper(ApplicantMapper.class);

//		Applicant currentApplicant = applicantRepository.getByEmail(applicantDTO.getEmail());
//
//		Applicant newApplicant = UpdateApplicant.getApplicant(currentApplicant, applicantDTO);
//
//		Applicant updatedApplicant = applicantRepository.save(newApplicant);
//
//		return mapper.getApplicantDTO(updatedApplicant);

		return null;
	}

	public List<ApplicantDTO> getApplicantsWithoutDocNum() {

		ApplicantMapper mapper = Mappers.getMapper(ApplicantMapper.class);

		List<Applicant> applicants = applicantRepository.findByDocumentNumberOrDocumentNumber("", null);

		System.out.println("Applicants are : " + applicants);

		List<ApplicantDTO> applicantDTO = applicants.stream().map(applicant -> mapper.getApplicantDTO(applicant))
				.collect(Collectors.toList());

		return applicantDTO;
	}

	public void submit(RequestDTO request) {
		Applicant applicant = new Applicant();
		applicant.setDob(request.getDob());
		applicant.setDocumentNumber(request.getDocumentNumber());
		applicant.setDocumentType(request.getDocumentNumber());
		applicant.setEmail(request.getEmail());
		applicant.setFirstName(request.getFirstName());
		applicant.setLastName(request.getLastName());
		applicant.setPhone(request.getPhone());
		applicant = applicantRepository.save(applicant);
		final Applicant saved_applicant = applicant;
		request.getApplications().forEach(application -> {
			application.setApplicant(saved_applicant);
			System.out.println(application.toString());
			applicationRepository.save(application);
		});
	}
}
