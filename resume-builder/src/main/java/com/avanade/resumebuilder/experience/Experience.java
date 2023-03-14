package com.avanade.resumebuilder.experience;

import java.util.List;

import com.avanade.resumebuilder.personEmployer.PersonEmployer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name = "Experience")
public class Experience {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Getter @Setter
    private Integer personEmployerId;

    @Getter @Setter
    private String position;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private List<PersonEmployer> personEmployers;

    public Experience() {
    }

    public Experience(Integer personEmployerId, String position, String description,
            List<PersonEmployer> personEmployers) {
        this.personEmployerId = personEmployerId;
        this.position = position;
        this.description = description;
        this.personEmployers = personEmployers;
    }

    public Experience(Integer id, Integer personEmployerId, String position, String description,
            List<PersonEmployer> personEmployers) {
        this.id = id;
        this.personEmployerId = personEmployerId;
        this.position = position;
        this.description = description;
        this.personEmployers = personEmployers;
    }


    
}
