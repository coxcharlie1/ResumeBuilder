package com.charliecox.resumebuilder.entity;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Person")
public class Person {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String emailAddress;

    @Getter @Setter
    private String occupation;

    @Getter @Setter
    private String education;
   
    
    //@Getter @Setter
    //@OneToMany(mappedBy = "person")
    // @JoinColumn(name = "personId")
    //@JsonManagedReference
    //private List<PersonEmployer> personEmployers;
    


    public Person(String firstName, String lastName, String emailAddress, String occupation, String education
           ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.occupation = occupation;
        this.education = education;
        //this.personEmployers = personEmployers;
    }






    public Person(Integer id, String firstName, String lastName, String emailAddress, String occupation,
            String education) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.occupation = occupation;
        this.education = education;
        //this.personEmployers = personEmployers;
    }






    public Person() {
    }

 

}
