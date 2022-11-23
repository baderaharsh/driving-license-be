package com.example.drivinglicense.mapper;

import com.example.drivinglicense.dto.ApplicantDTO;
import com.example.drivinglicense.model.Applicant;

public class UpdateApplicant {
	public static Applicant getApplicant(Applicant applicant,ApplicantDTO applicantDTO) {

        if ( applicantDTO.getDob() != null ) {
            applicant.setDob( applicantDTO.getDob() );
        }
        if ( applicantDTO.getDocumentNumber() != null ) {
            applicant.setDocumentNumber( applicantDTO.getDocumentNumber() );
        }
        if ( applicantDTO.getDocumentType() != null ) {
            applicant.setDocumentType( applicantDTO.getDocumentType() );
        }
        if ( applicantDTO.getEmail() != null ) {
            applicant.setEmail( applicantDTO.getEmail() );
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
