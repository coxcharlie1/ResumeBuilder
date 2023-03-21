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

import com.charliecox.resumebuilder.entity.PersonEmployer;
import com.charliecox.resumebuilder.service.PersonEmployerService;

@RestController
@RequestMapping(path = "/api/v1/personEmployer")
public class PersonEmployerController {

    private PersonEmployerService service;

    @Autowired
    public PersonEmployerController(PersonEmployerService personEmployerService)
    {
        this.service = personEmployerService;
    }
    
    @GetMapping("/")
    public ResponseEntity<List<PersonEmployer>> GetAllPersonEmployers()
    {
        List<PersonEmployer> personEmployers = service.GetAllPersonEmployers();

        return (ResponseEntity<List<PersonEmployer>>) ResponseEntity.ok(personEmployers);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonEmployer> GetPersonEmployer(@PathVariable Integer id) throws Exception
    {
        PersonEmployer personEmployer = service.GetPersonEmployer(id);

        return ResponseEntity.ok(personEmployer);
    }
    
    @PostMapping(value = "/", consumes = {"application/json"})
    public ResponseEntity<PersonEmployer> PostPersonEmployer(@RequestBody PersonEmployer personEmployer)
    {
        
        PersonEmployer savedPerson = service.PostPersonEmployer(personEmployer);
                    
        return ResponseEntity.ok(savedPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonEmployer> UpdatePersonEmployer(@RequestBody PersonEmployer personEmployer, @PathVariable Integer id) throws Exception
    {
        PersonEmployer updatedPersonEmployer = service.UpdatePersonEmployer(personEmployer, id);

        return  (ResponseEntity<PersonEmployer>) ResponseEntity.ok(updatedPersonEmployer);
    }

    @DeleteMapping("/{id}")
    public void DeletePersonEmployer(@PathVariable Integer id)
    {
        service.DeletePersonEmployer(id);
        
    }


    
}
