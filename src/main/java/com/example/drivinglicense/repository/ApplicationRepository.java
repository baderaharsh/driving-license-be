package com.example.drivinglicense.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.drivinglicense.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	@Query("SELECT ap FROM Application ap, Applicant a WHERE a.email = :email AND ap.applicant = a.id AND ap.deleted = false")
	Optional<Application> getApplicationByEmail(String email);
}
