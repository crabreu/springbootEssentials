package com.example.springbootEssentials.controller;


import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.example.springbootEssentials.model.Curso;
import com.example.springbootEssentials.model.CursoRepository;

import jakarta.websocket.server.PathParam;
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
                 return cursoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Curso get(@PathVariable("id") Long id) throws BadRequestException{
        if(!Objects.isNull(id)){
            log.info("Listando o curso: {}",id);
            
        }else{
            throw new BadRequestException();
        }
        return cursoRepository.findById(id).get();
    }
    @PostMapping()
    public Curso save(@RequestBody Curso curso)  throws BadRequestException{
        if(!Objects.isNull(curso.getId())){
            log.info("Atualiza o curso: {}",curso);
            
        }else{
            throw new BadRequestException();
        }
        return cursoRepository.save(curso);
    }
    @PatchMapping("/{id}")
    public Curso update(@PathVariable ("id") Long id, @RequestBody Curso curso) throws BadRequestException{
        if(!Objects.isNull(curso.getId())){
            log.info("Atualiza o curso: {}",curso);
            
        }else{
            throw new BadRequestException();
        }
        return cursoRepository.save(curso);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Long id)  throws BadRequestException{
        if(!Objects.isNull(id)){
            log.info("Deleta o curso: {}",id);
            
        }else{
            throw new BadRequestException();
        }
        cursoRepository.deleteById(id);
    }

}
