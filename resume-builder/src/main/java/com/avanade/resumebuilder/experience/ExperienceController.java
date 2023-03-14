package com.avanade.resumebuilder.experience;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/experience")
public class ExperienceController {
    
    private ExperienceService service;

    @Autowired
    public ExperienceController(ExperienceService experienceService)
    {
        this.service = experienceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Experience>> GetAllExperiences()
    {
        List<Experience> experiences = service.GetAllExperiences();

        return (ResponseEntity<List<Experience>>) ResponseEntity.ok(experiences);
    }
}
