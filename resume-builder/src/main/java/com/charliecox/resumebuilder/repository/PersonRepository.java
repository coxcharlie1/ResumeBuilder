package com.charliecox.resumebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charliecox.resumebuilder.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    
}
