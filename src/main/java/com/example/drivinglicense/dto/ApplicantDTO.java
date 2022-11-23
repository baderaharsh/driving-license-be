package com.example.drivinglicense.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDTO {
	private String firstName;
	private String lastName;
	private String email;
	private Long phone;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime dob;
	private String documentType;
	private String documentNumber;
}
