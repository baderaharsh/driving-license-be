package com.example.drivinglicense.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.drivinglicense.constants.CustomErrors;
import com.example.drivinglicense.dto.ApplicantRequestDTO;
import com.example.drivinglicense.dto.ApplicantResponseDTO;
import com.example.drivinglicense.dto.ResponseError;
import com.example.drivinglicense.model.Applicant;

@Mapper
public interface ApplicantMapper {
	Applicant getApplicant(ApplicantRequestDTO applicantDTO);
	ApplicantRequestDTO getApplicantDTO(Applicant applicant);
	@Mapping(source = "customError", target = "error")
	ApplicantResponseDTO getErrorResponse(ResponseError customError);
	ApplicantResponseDTO getApplicantResponseDTO(Applicant applicant);
}
