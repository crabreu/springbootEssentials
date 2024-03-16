package com.example.springbootEssentials.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "matriculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matriculas {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private long idCurso;
    
    private long idEstudante;

    @ManyToOne
    private Curso curso;
    @ManyToOne
    private Estudante estudante;
}
