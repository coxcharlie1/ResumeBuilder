package com.charliecox.resumebuilder.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Employer")
public class Employer {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    private String companyName;
    
    
    //@Getter @Setter
    //@OneToMany(mappedBy = "employer")
    //@JsonManagedReference
    //private List<PersonEmployer> personEmployers;
    
    
    
    public Employer(String companyName) {
        this.companyName = companyName;
        //this.personEmployers = personEmployers;
    }



    public Employer(Integer id, String companyName) {
        this.id = id;
        this.companyName = companyName;
        //this.personEmployers = personEmployers;
    }



    public Employer() {
    }

    
  
    
}
