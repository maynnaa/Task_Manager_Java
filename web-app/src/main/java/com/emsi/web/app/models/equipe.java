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
@Table(name = "equipe")
public class equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idequipe")
    private Integer idequipe;
    private String nom;


    @OneToMany(mappedBy = "equipe")
    private List<employer> employes;

    @OneToOne
    @JoinColumn(name = "idchef")
    private chef_de_projet chefDeProjet;

}
