package com.example.springbootEssentials.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "matriculas")
@Data
public class Matriculas {

    @Id
    private long id;
 
    private long idCurso;

    private long idEstudante;
}
