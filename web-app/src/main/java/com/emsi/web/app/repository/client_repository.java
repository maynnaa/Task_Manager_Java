package com.emsi.web.app.repository;
import com.emsi.web.app.models.chef_de_projet;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emsi.web.app.models.client;

import java.util.List;
import java.util.Optional;

public interface client_repository extends JpaRepository <client,Integer>{

    Optional<client> findByIdclient(Integer id);
    Optional<client> findByEmail(String email);


    List<client> findAll();
}
