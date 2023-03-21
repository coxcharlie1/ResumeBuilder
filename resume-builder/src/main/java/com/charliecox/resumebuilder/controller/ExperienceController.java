package com.charliecox.resumebuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charliecox.resumebuilder.entity.Experience;
import com.charliecox.resumebuilder.service.ExperienceService;

@RestController
@RequestMapping(path = "/api/v1/experience")
public class ExperienceController {
    
    private ExperienceService service;

    @Autowired
    public ExperienceController(ExperienceService experienceService)
    {
        this.service = experienceService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Experience>> GetAllExperiences()
    {
        List<Experience> experiences = service.GetAllExperiences();

        return (ResponseEntity<List<Experience>>) ResponseEntity.ok(experiences);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Experience> GetExperience(@PathVariable Integer id) throws Exception
    {
        Experience experience = service.GetExperience(id);

        return ResponseEntity.ok(experience);
    }

    @PostMapping("/")
    public ResponseEntity<Experience> PostExperience(@RequestBody Experience experience)
    {
        Experience savedExperience = service.PostExperience(experience);

        return ResponseEntity.ok(savedExperience);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> UpdateExperience(@PathVariable Integer id, @RequestBody Experience experience) throws Exception
    {
        Experience updatedExperience = service.UpdateExperience(id, experience);
        return ResponseEntity.ok(updatedExperience);
    }
}
