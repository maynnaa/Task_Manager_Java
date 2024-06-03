package com.emsi.web.app.services.impl;

import com.emsi.web.app.models.client;
import com.emsi.web.app.repository.client_repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {
    List<client> getAllClients();
}

