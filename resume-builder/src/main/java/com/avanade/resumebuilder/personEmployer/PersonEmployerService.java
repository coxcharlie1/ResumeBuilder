package com.avanade.resumebuilder.personEmployer;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonEmployerService {

    public List<PersonEmployer> GetAllPersonEmployers()
    {
        List<PersonEmployer> personEmployers = List.of(
            new PersonEmployer(1, 1, LocalDate.parse("2023-02-27"),LocalDate.parse("2023-03-30"), null, null)
        );
        return personEmployers;
    }
    
}
