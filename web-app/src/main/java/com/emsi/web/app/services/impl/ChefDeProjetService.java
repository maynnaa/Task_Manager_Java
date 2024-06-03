package com.emsi.web.app.services.impl;

import com.emsi.web.app.models.chef_de_projet;
import com.emsi.web.app.repository.chef_de_projet_repository;
import org.springframework.stereotype.Service;

@Service
public class ChefDeProjetService {
    private final chef_de_projet_repository chefDeProjetRepository;

    public ChefDeProjetService(chef_de_projet_repository chefDeProjetRepository) {
        this.chefDeProjetRepository = chefDeProjetRepository;
    }

    public void saveChefDeProjet(chef_de_projet chefDeProjet) {
        chefDeProjetRepository.save(chefDeProjet);
    }
}
