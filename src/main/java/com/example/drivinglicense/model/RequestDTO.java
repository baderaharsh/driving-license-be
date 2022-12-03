package com.example.drivinglicense.model;

import java.time.LocalDateTime;
import java.util.List;

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
