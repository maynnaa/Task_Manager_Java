package com.emsi.web.app.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Builder
public class projet_dto {


    private Integer idprojet;
    private String nomprojet;
    private String description;
    private String status;
    private String avancement;
    private String date_debut;
    private String date_fin;


}
