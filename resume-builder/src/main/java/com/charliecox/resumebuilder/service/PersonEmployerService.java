package com.charliecox.resumebuilder.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charliecox.resumebuilder.entity.Employer;
import com.charliecox.resumebuilder.entity.Person;
import com.charliecox.resumebuilder.entity.PersonEmployer;
import com.charliecox.resumebuilder.repository.PersonEmployerRepository;

@Service
public class PersonEmployerService {

    PersonEmployerRepository repository;

    @Autowired
    public PersonEmployerService(PersonEmployerRepository personEmployerRepository)
    {
        this.repository = personEmployerRepository;
    }

    
    public List<PersonEmployer> GetAllPersonEmployers()
    {
        List<PersonEmployer> personEmployers = repository.findAll();
        return personEmployers;

        
    }

    public PersonEmployer GetPersonEmployer(int id) throws Exception
    {
        Optional<PersonEmployer> personEmployer = repository.findById(id);

        if(personEmployer.isEmpty())
        {
         throw new Exception("id:" + id);
        }
 
        return personEmployer.get();
    }

    public PersonEmployer PostPersonEmployer(PersonEmployer personEmployer)
    {
        
        
        repository.save(personEmployer);
        return personEmployer;
    }
    
    public PersonEmployer UpdatePersonEmployer(PersonEmployer personEmployer, int id) throws Exception
    {
         //find person by id
         Optional<PersonEmployer> personOptional = repository.findById(id);
      
         //check if they do exsist
         if(personOptional.isEmpty())
         {
            
            throw new Exception("id: " + id + " not found");
     
         }
         //set: 
         personEmployer.setId(id);
 
         //save to repository
         repository.save(personEmployer);
 
         //return okay
         return personEmployer;
    }

    public void DeletePersonEmployer(int id)
    {
        repository.deleteById(id);
    }
    
}
