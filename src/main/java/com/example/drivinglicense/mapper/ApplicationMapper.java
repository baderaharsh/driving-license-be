package com.example.drivinglicense.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.drivinglicense.dto.ApplicationRequestDTO;
import com.example.drivinglicense.dto.ApplicationResponse;
import com.example.drivinglicense.dto.ApplicationResponseDTO;
import com.example.drivinglicense.dto.ResponseError;
import com.example.drivinglicense.model.Application;

@Mapper
public interface ApplicationMapper {
	
	@Mappings({
		@Mapping(target = "type", source = "application.type"),
		@Mapping(target = "category", source = "application.category"),
		@Mapping(target = "status", source = "status")
	})
	Application getApplication(ApplicationRequestDTO application, String status);
	@Mapping(target = "error", source = "error")
	ApplicationResponseDTO getApplicationErrorResponse(ResponseError error);
	ApplicationResponseDTO getApplicationResponse(Application application);
}
