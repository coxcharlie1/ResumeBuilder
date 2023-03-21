package com.charliecox.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charliecox.resumebuilder.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer>{
    
}
