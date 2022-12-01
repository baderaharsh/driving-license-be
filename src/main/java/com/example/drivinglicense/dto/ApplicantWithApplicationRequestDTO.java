package com.example.drivinglicense.dto;

import com.example.drivinglicense.model.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApplicantWithApplicationRequestDTO {
	private Applicant applicant;
}
