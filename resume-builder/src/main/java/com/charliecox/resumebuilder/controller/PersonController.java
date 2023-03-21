package com.charliecox.resumebuilder.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.charliecox.resumebuilder.entity.Person;
import com.charliecox.resumebuilder.service.PersonService;

@CrossOrigin(origins = { "http://localhost:3000/" })
@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {

    //private PersonRepository repository;
    private PersonService service;

    @Autowired
    public PersonController(PersonService personService)
    {
        this.service = personService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Person>> GetAllPersons()
    {
        List<Person> persons = service.GetAllPersons();

        ResponseEntity resp = ResponseEntity.ok(persons);
        return (ResponseEntity<List<Person>>) resp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> GetPerson(@PathVariable Integer id) throws Exception
    {
        Person person = service.GetPerson(id);

        return ResponseEntity.ok(person);
    }

    @PostMapping("/")
    public ResponseEntity<Person> PostPerson(@RequestBody Person person)
    {
        Person savedPerson = service.PostPerson(person);
                    
        return (ResponseEntity<Person>) ResponseEntity.ok(savedPerson);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> UpdatePerson(@RequestBody Person person, @PathVariable Integer id) throws Exception
    {
       
       Person updatedPerson = service.UpdatePerson(person, id);
       return  (ResponseEntity<Person>) ResponseEntity.ok(updatedPerson);
        
    }
    @DeleteMapping("/{id}")
    public void DeletePerson(@PathVariable Integer id)
    {
        service.DeletePerson(id);
        
    }
}
