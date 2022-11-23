package com.example.drivinglicense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.drivinglicense.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
