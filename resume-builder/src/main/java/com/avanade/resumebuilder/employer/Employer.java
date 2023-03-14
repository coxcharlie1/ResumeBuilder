package com.avanade.resumebuilder.employer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public Employer() {
    }

    public Employer(String companyName) {
        this.companyName = companyName;
    }

    public Employer(Integer id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }
    
}
