package com.charliecox.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charliecox.resumebuilder.entity.PersonEmployer;

@Repository
public interface PersonEmployerRepository extends JpaRepository<PersonEmployer, Integer>{
    
}
