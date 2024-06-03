package com.emsi.web.app.repository;
import com.emsi.web.app.models.chef_de_projet;
import com.emsi.web.app.models.employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface chef_de_projet_repository extends JpaRepository <chef_de_projet , Integer> {
Optional<chef_de_projet> findByIdchef(Integer id);
chef_de_projet findByEmailAndChefpass(String email,String c_pass);
chef_de_projet findByEmail(String mail);

}
