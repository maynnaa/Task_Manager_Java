package com.emsi.web.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "chef_de_projet")
public class chef_de_projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchef")
    private Integer idchef;
    private String nom;
    private String prenom;
    private String chefpass;
    private String email;
    @OneToMany(mappedBy = "chefDeProjet", cascade = CascadeType.REMOVE)
    private List<employer> employes;
}
