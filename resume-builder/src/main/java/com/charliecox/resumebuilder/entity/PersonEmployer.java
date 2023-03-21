package com.charliecox.resumebuilder.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Person_Employer")
public class PersonEmployer {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private Integer id;

    
    //@Getter @Setter
    //@JoinColumn(name = "personId", referencedColumnName = "id") //FK name for person on Person_Employer
    //private Integer personId;
    

    
    //@Getter @Setter
    //@JoinColumn(name = "employerId", referencedColumnName = "id") //FK name for employer on Person_Employer
    //private Integer employerId;
    

    @Getter @Setter
    private LocalDate startDate;

    @Getter @Setter
    private LocalDate endDate;

    @Getter @Setter
    //@JsonManagedReference
    //@OneToMany(mappedBy = "personEmployer")
    @ManyToOne
    @JoinColumn(name = "personId") 
    private Person person;

    @Getter @Setter
    //@JsonManagedReference
    //@OneToMany(mappedBy = "personEmployer")
    @ManyToOne
    @JoinColumn(name = "employerId") 
    private Employer employer;



    public PersonEmployer(LocalDate startDate, LocalDate endDate, Person person,
            Employer employer) {
        //this.personId = personId;
        //this.employerId = employerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.person = person;
        this.employer = employer;
    }



    public PersonEmployer(Integer id, LocalDate startDate, LocalDate endDate,
            Person person, Employer employer) {
        this.id = id;
        //this.personId = personId;
        //this.employerId = employerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.person = person;
        this.employer = employer;
    }



    public PersonEmployer() {
    }

    
    
  


    
}
