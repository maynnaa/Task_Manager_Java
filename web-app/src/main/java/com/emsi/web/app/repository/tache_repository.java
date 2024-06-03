package com.emsi.web.app.repository;

import com.emsi.web.app.models.tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface tache_repository extends JpaRepository <tache,Integer> {

    @Query("SELECT t FROM tache t JOIN t.employer e WHERE e.email = :email")

    List<tache> findTacheByEmployerEmail(@Param("email") String email);


    void deleteById(Integer id);

    Optional<tache> findByIdtache(Integer taskId);


    @Query("SELECT COUNT(t.idtache) FROM tache t JOIN t.employer e JOIN e.chefDeProjet c WHERE t.status = 'Terminé' AND e.chefDeProjet.idchef = c.idchef AND c.email = :email")
    Integer taskcompletecount(@Param("email") String email);


    @Query("SELECT COUNT(t.idtache) FROM tache t JOIN t.employer e JOIN e.chefDeProjet c WHERE e.chefDeProjet.idchef = c.idchef AND c.email = :email")
    Integer alltaskscount(@Param("email") String email);

}
