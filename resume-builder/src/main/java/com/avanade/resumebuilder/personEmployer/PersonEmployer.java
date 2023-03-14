package com.avanade.resumebuilder.personEmployer;

import java.time.LocalDate;
import java.util.List;

import com.avanade.resumebuilder.employer.Employer;
import com.avanade.resumebuilder.person.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Person_Employer")
public class PersonEmployer {

    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    private Integer personId;

    @Getter @Setter
    private Integer employerId;

    @Getter @Setter
    private LocalDate startDate;

    @Getter @Setter
    private LocalDate endDate;

    @Getter @Setter
    private List<Person> persons;

    @Getter @Setter
    private List<Employer> employers;

    public PersonEmployer() {
    }

    public PersonEmployer(Integer personId, Integer employerId, LocalDate startDate, LocalDate endDate,
            List<Person> persons, List<Employer> employers) {
        this.personId = personId;
        this.employerId = employerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
        this.employers = employers;
    }

    public PersonEmployer(Integer id, Integer personId, Integer employerId, LocalDate startDate, LocalDate endDate,
            List<Person> persons, List<Employer> employers) {
        this.id = id;
        this.personId = personId;
        this.employerId = employerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
        this.employers = employers;
    }


    
}
