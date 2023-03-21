package com.charliecox.resumebuilder.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charliecox.resumebuilder.entity.Person;
import com.charliecox.resumebuilder.repository.PersonRepository;
import com.fasterxml.jackson.databind.ext.CoreXMLDeserializers;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository personRepository)
    {
        this.repository = personRepository;
    }

    public List<Person> GetAllPersons()
    {
        /*
        List<Person> persons = List.of(
            new Person(1, "Charlie", "Cox", "charlie.cox@email.com", "Entry Level Software Engineer", "Computer Science"),
            new Person(1, "Jayla", "Cox", "jayla.cox@email.com", "Sous Chef", "Culinary Arts")
            
        );
        */
        List<Person> persons = repository.findAll();
        return persons;
        
    }
    public Person GetPerson(int id) throws Exception
    {
       Optional<Person> person = repository.findById(id);

       if(person.isEmpty())
       {
        throw new Exception("id:" + id);
       }

       return person.get();
    }
    public Person PostPerson(Person person)
    {
       //maybe do some checks here
        repository.save(person);
        return person;
    }
    public Person UpdatePerson(Person person, int id)
    {
        //find person by id
        Optional<Person> personOptional = repository.findById(id);
      
        //check if they do exsist
        if(personOptional.isEmpty())
        {
           
            return null;
    
        }
        //set: 
        person.setId(id);

        //save to repository
        repository.save(person);

        //return okay
        return person;
    }
    public void DeletePerson(int id)
    {
        repository.deleteById(id);
    }

    
}
