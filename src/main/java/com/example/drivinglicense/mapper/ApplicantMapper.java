package com.example.drivinglicense.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.drivinglicense.dto.ApplicantDTO;
import com.example.drivinglicense.model.Applicant;

@Mapper
public interface ApplicantMapper {
	Applicant getApplicant(ApplicantDTO applicantDTO);
	ApplicantDTO getApplicantDTO(Applicant applicant);
}
