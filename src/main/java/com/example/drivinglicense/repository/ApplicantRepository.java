package com.example.drivinglicense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.drivinglicense.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	Applicant getByEmail(String email);
	Applicant getByFirstNameAndPhoneAndEmail(String firstName, Long phone, String email);
	List<Applicant> findByDocumentNumberOrDocumentNumber(String documentNumber, String docNum);
}
