package com.example.drivinglicense.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApplicantResponse {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Long phone;
	private LocalDateTime dob;
	private String documentType;
	private String documentNumber;
}
