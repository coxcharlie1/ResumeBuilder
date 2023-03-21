package com.charliecox.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charliecox.resumebuilder.entity.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
    
}
