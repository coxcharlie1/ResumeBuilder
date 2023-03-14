package com.avanade.resumebuilder.experience;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExperienceService {
    
    public List<Experience> GetAllExperiences()
    {
        List<Experience> experiences = List.of(
            new Experience(1, 1, "Frontend Developer", "Fixed UI bugs within React application", null)
        );
        return experiences;
    }
}
