package com.example.drivinglicense.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApplicationResponse {
	private String applicationNumber;
	private String type;
	private String category;
	private String status;
	private LocalDateTime submittedOn;
	private LocalDateTime lastUpdatedOn;
}
