package com.avanade.resumebuilder.personEmployer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/personEmployer")
public class PersonEmployerController {

    private PersonEmployerService service;

    @Autowired
    public PersonEmployerController(PersonEmployerService personEmployerService)
    {
        this.service = personEmployerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonEmployer>> GetAllEmployers()
    {
        List<PersonEmployer> personEmployers = service.GetAllPersonEmployers();

        return (ResponseEntity<List<PersonEmployer>>) ResponseEntity.ok(personEmployers);
        
    }


    
}
