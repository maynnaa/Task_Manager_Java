package com.emsi.web.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employer")
public class employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemployer")
    private Integer idemployer;
    private String nom;
    private String prenom;
    private String email;
    private String emppass;
    private String imgurl;

    @ManyToOne
    @JoinColumn(name = "idprojet")
    private projet projet;

    @ManyToOne
    @JoinColumn(name = "idchef")
    private chef_de_projet chefDeProjet;

    @ManyToOne
    @JoinColumn(name = "idequipe")
    private equipe equipe;
}

