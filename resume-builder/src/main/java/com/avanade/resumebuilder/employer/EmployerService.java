package com.avanade.resumebuilder.employer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    
    private EmployerRepository repository;

    public EmployerService(EmployerRepository employerRepository)
    {
        this.repository = employerRepository;

    }

    public List<Employer> GetAllEmployers()
    {
        
        List<Employer> employers = repository.findAll();

        return employers;
        
    }
    public Employer GetEmployer(int id) throws Exception
    {
        Optional<Employer> employer = repository.findById(id);

        if(employer.isEmpty())
        {
            throw new Exception("id: " + id + "not found.");
        }
        return employer.get();
    }
    public Employer PostEmployer(Employer employer)
    {
        repository.save(employer);
        return employer;
    }

    public Employer UpdateEmployer(Employer employer, int id) throws Exception
    {
        Optional<Employer> employerOptional = repository.findById(id);

        if(employerOptional.isEmpty())
        {
            throw new Exception("id: " + id + " not found");
        }

        employer.setId(id);

        repository.save(employer);

        return employer;
    }
    
    public void DeleteEmployer(int id)
    {
        repository.deleteById(id);
    }
}
