package com.example.drivinglicense.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApplicantWithApplicationRequestDTO {
	private ApplicantRequestDTO applicant;
	private ApplicationRequestDTO application;
}
