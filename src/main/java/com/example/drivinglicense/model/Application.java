package com.example.drivinglicense.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="application")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="status")
	private String status;
	
	@CreationTimestamp
	@Column(name="submitted_on")
	private LocalDateTime submittedOn;
	
	@UpdateTimestamp
	@Column(name="last_updated")
	private LocalDateTime lastUpdated;
	
	@Column(name = "deleted")
	private boolean deleted;
	
	@ManyToOne
	@JoinColumn(name = "applicant_id")
	private Applicant applicant;
	
}
