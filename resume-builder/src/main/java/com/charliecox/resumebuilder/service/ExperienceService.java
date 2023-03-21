package com.charliecox.resumebuilder.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Service;

import com.charliecox.resumebuilder.entity.Experience;
import com.charliecox.resumebuilder.repository.ExperienceRepository;

@Service
public class ExperienceService {

    private ExperienceRepository repository;

    public ExperienceService(ExperienceRepository experienceRepository)
    {
        this.repository = experienceRepository;

    }
    
    public List<Experience> GetAllExperiences()
    {
        
        return repository.findAll();
    }

    public Experience GetExperience(int id) throws Exception
    {
        Optional<Experience> experience = repository.findById(id);

        if(experience.isEmpty())
        {
         throw new Exception("id:" + id);
        }
 
        return experience.get();
    }

    public Experience PostExperience(Experience experience)
    {
        repository.save(experience);
        
        return experience;
    }

    public Experience UpdateExperience(int id, Experience experience) throws Exception
    {
           //find person by id
           Optional<Experience> experienceOptional = repository.findById(id);
      
           //check if they do exsist
           if(experienceOptional.isEmpty())
           {
              
              throw new Exception("id: " + id + " not found");
       
           }
           //set: 
           experience.setId(id);
   
           //save to repository
           repository.save(experience);
   
           //return okay
           return experience;
    }
}
