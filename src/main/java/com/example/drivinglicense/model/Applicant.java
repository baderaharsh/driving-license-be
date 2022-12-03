package com.example.drivinglicense.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.drivinglicense.model.common.Timelog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="applicant")
public class Applicant extends Timelog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone")
	private Long phone;
	
	@Column(name="email")
	private String email;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name="dob")
	private LocalDateTime dob;
	
	@Column(name="document_type")
	private String documentType;
	
	@Column(name="document_number")
	private String documentNumber;

}
