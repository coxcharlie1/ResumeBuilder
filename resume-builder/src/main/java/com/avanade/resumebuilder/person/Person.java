package com.avanade.resumebuilder.person;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public Person() {
    }

    public Person(String firstName, String lastName, String emailAddress, String occupation, String education) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.occupation = occupation;
        this.education = education;
    }

    public Person(Integer id, String firstName, String lastName, String emailAddress, String occupation,
            String education) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.occupation = occupation;
        this.education = education;
    }

}
