package com.example.drivinglicense.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class RequestDTO {

	private String firstName;
	private String lastName;
	private Long phone;
	private String email;
	private LocalDateTime dob;
	private String documentType;
	private String documentNumber;
	private List<Application> applications;
}
