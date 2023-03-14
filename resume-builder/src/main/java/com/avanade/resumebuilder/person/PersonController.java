package com.avanade.resumebuilder.person;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


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
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> GetAllPersons()
    {
        List<Person> persons = service.GetAllPersons();

        return (ResponseEntity<List<Person>>) ResponseEntity.ok(persons);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> GetPerson(@PathVariable Integer id) throws Exception
    {
        Person person = service.GetPerson(id);

        return ResponseEntity.ok(person);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> PostPerson(@RequestBody Person person)
    {
        Person savedPerson = service.PostPerson(person);
                    
        return (ResponseEntity<Person>) ResponseEntity.ok(savedPerson);
        
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> UpdatePerson(@RequestBody Person person, @PathVariable Integer id)
    {
       
       Person updatedPerson = service.UpdatePerson(person, id);
       return  (ResponseEntity<Person>) ResponseEntity.ok(updatedPerson);
        
    }
    @DeleteMapping("/persons/{id}")
    public void DeletePerson(@PathVariable Integer id)
    {
        service.DeletePerson(id);
        
    }
}
