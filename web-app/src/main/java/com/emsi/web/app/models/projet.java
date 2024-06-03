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
@Table(name = "projet")
public class projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprojet")
    private Integer idprojet;
    private String nomprojet;
    private String description;
    private String status;
    private String avancement;
    private String date_debut;
    private String date_fin;


    @ManyToOne
    @JoinColumn(name = "idchef")
    private chef_de_projet chefDeProjet;

    @OneToMany(mappedBy = "projet")
    private List<employer> employes;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private client client;

    @ManyToOne
    @JoinColumn(name = "idtache")
    private tache tache;

}
