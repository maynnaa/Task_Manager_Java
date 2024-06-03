package com.emsi.web.app.services.impl;

import com.emsi.web.app.models.client;
import com.emsi.web.app.repository.client_repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    // Implement the getAllClients() method to fetch data from your data source
    private final client_repository clientRepository;

    public ClientServiceImpl(client_repository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<client> getAllClients() {
        // Implement fetching clients from your data source (e.g., database)
        // Return a list of Client objects
        return clientRepository.findAll();
    }
}
