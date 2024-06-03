package com.emsi.web.app.repository;

import com.emsi.web.app.models.chef_de_projet;
import com.emsi.web.app.models.employer;
import com.emsi.web.app.models.tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface employer_repository extends JpaRepository<employer , Integer> {

    Optional<employer> findByIdemployer(Integer id);

    Optional<employer> findByNom(String nom);

    employer findByEmailAndEmppass(String email, String password);
    employer findByEmail(String mail);

    @Query("select e from employer e join e.chefDeProjet c where c.email = :email")
    List<employer> findEmployerByChef(@Param("email") String email);


}
