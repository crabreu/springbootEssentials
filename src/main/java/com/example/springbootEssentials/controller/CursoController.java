package com.example.springbootEssentials.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootEssentials.model.Curso;
import com.example.springbootEssentials.model.CursoRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/curso")
@Slf4j
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping()
    public List<Curso> list() {
        log.info("Listando os cursos.");
        /*List<Curso> cursos = new ArrayList<>();
        Curso curso = new Curso();
        curso.setTitulo("curso1");
        curso.setCreditos(6);
        cursos.add(curso);*/

        return cursoRepository.findAll();
    }

}
