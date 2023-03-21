package com.charliecox.resumebuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charliecox.resumebuilder.entity.Employer;
import com.charliecox.resumebuilder.service.EmployerService;

@RestController
@RequestMapping(path = "/api/v1/employer")
public class EmployerController {
    
    private EmployerService service;

    @Autowired
    public EmployerController(EmployerService employerService)
    {
        this.service = employerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Employer>> GetAllEmployers()
    {
        List<Employer> employers = service.GetAllEmployers();

        return (ResponseEntity<List<Employer>>) ResponseEntity.ok(employers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employer> GetEmployer(@PathVariable Integer id) throws Exception
    {
        Employer employer = service.GetEmployer(id);

        return ResponseEntity.ok(employer);
    }

    @PostMapping("/")
    public ResponseEntity<Employer> PostEmployer(@RequestBody Employer employer)
    {
        Employer savedEmployer = service.PostEmployer(employer);

        return ResponseEntity.ok(savedEmployer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employer> UpdateEmployer(@RequestBody Employer employer, @PathVariable Integer id) throws Exception
    {
        Employer updatedEmployer = service.UpdateEmployer(employer, id);
        return ResponseEntity.ok(updatedEmployer);
    }

    @DeleteMapping("/{id}")
    public void DeleteEmployer(@PathVariable Integer id)
    {
        service.DeleteEmployer(id);
    }

    
}
