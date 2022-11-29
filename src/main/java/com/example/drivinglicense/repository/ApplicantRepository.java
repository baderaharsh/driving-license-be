package com.example.drivinglicense.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.drivinglicense.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	Optional<Applicant> findByEmail(String email);
	Applicant findByFirstNameAndPhoneAndEmail(String firstName, Long phone, String email);
	List<Applicant> findByDocumentNumberOrDocumentNumber(String documentNumber, String docNum);
}
