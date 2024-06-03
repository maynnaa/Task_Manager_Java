package com.emsi.web.app.services.impl;

import com.emsi.web.app.models.employer;
import com.emsi.web.app.repository.employer_repository;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    private final employer_repository employerRepository;

    public EmployerService(employer_repository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public void saveEmployer(employer employer) {
        employerRepository.save(employer);
    }
}
