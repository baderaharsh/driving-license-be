package com.example.drivinglicense.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import com.example.drivinglicense.dto.ApplicantRequestDTO;
import com.example.drivinglicense.dto.ApplicantResponse;
import com.example.drivinglicense.dto.ApplicantResponseDTO;
import com.example.drivinglicense.dto.ApplicantWithApplicationResponseDTO;
import com.example.drivinglicense.dto.ApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicationResponse;
import com.example.drivinglicense.dto.ApplicationResponseDTO;
import com.example.drivinglicense.dto.ResponseError;
import com.example.drivinglicense.model.Applicant;
import com.example.drivinglicense.model.Application;

@Mapper( nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ApplicantMapper {
	Applicant getApplicant(ApplicantRequestDTO applicantDTO);
	ApplicantRequestDTO getApplicantDTO(Applicant applicant);
	@Mapping(source = "customError", target = "error")
	ApplicantWithApplicationResponseDTO getErrorResponse(ResponseError customError);
	@Mapping(source = "customError", target = "error")
	ApplicantResponseDTO getApplicantErrorResponse(ResponseError customError);
	ApplicantResponseDTO getApplicantResponseDTO(Applicant applicant);
	ApplicantResponse getApplicantResponse(Applicant applicant);
	ApplicationResponse getApplicationResponse(ApplicationResponseDTO applicationResponseDTO);
	
	default Applicant getUpdatedApplicant(Applicant applicant, ApplicantRequestDTO applicantDTO) {
		
		if ( applicantDTO.getDob() != null ) {
            applicant.setDob( applicantDTO.getDob() );
        }
        if ( applicantDTO.getDocumentNumber() != null ) {
            applicant.setDocumentNumber( applicantDTO.getDocumentNumber() );
        }
        if ( applicantDTO.getDocumentType() != null ) {
            applicant.setDocumentType( applicantDTO.getDocumentType() );
        }
        if ( applicantDTO.getFirstName() != null ) {
            applicant.setFirstName( applicantDTO.getFirstName() );
        }
        if ( applicantDTO.getLastName() != null ) {
            applicant.setLastName( applicantDTO.getLastName() );
        }
        if ( applicantDTO.getPhone() != null ) {
            applicant.setPhone( applicantDTO.getPhone() );
        }
		
		return applicant;
	}
}
