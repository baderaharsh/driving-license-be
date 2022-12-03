package com.example.drivinglicense.model.common;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public class Timelog {
	
	@CreationTimestamp
	@Column(name = "created_on")
	private LocalDateTime createdOn;
	
	@UpdateTimestamp
	@Column(name = "last_updated_on")
	private LocalDateTime lastUpdatedOn;
	
	@Column(name = "active")
	private boolean active;
}
