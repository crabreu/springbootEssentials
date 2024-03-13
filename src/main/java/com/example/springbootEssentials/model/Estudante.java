package com.example.springbootEssentials.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "estudantes")
@Data
public class Estudante {
    @Id
    private long id;

    private String nome;

    private int creditos;

    @OneToMany
    private List<Matriculas> matriculas;
}
