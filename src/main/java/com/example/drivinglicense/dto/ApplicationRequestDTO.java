package com.example.drivinglicense.dto;

import lombok.Data;

@Data
public class ApplicationRequestDTO {
	private String applicantEmail;
	private String type;
	private String category;
}
