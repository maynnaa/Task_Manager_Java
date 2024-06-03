package com.emsi.web.app.services.impl;

import com.emsi.web.app.models.employer;
import com.emsi.web.app.repository.employer_repository;
import com.emsi.web.app.repository.tache_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefemployeSERVICE {

    private final employer_repository employerRepository;

    @Autowired
    public ChefemployeSERVICE(employer_repository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public List<employer> findEmployerByChef(String email) {
        return employerRepository.findEmployerByChef(email);
    }
}
