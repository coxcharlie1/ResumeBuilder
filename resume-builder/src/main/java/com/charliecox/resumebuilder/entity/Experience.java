package com.charliecox.resumebuilder.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Experience")
public class Experience {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //@Getter @Setter
    //private Integer personEmployerId;

    @Getter @Setter
    private String position;

    @Getter @Setter
    private String description;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "personEmployerId")
    private PersonEmployer personEmployer;

    public Experience() {
    }

    public Experience(String position, String description, PersonEmployer personEmployer) {
        //this.personEmployerId = personEmployerId;
        this.position = position;
        this.description = description;
        this.personEmployer = personEmployer;

        
    }

    public Experience(Integer id, String position, String description, PersonEmployer personEmployer) {
        this.id = id;
        //this.personEmployerId = personEmployerId;
        this.position = position;
        this.description = description;
        this.personEmployer = personEmployer;
        
    }


    
}
