package com.emsi.web.app.repository;

import com.emsi.web.app.models.projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface projet_repository extends JpaRepository<projet, String> {

    Optional<projet> findByNomprojet(String name);

}
