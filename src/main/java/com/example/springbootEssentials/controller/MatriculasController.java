package com.example.springbootEssentials.controller;


import java.util.Date;
import java.util.List;
import java.util.Objects;
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

import com.example.springbootEssentials.model.Curso;
import com.example.springbootEssentials.model.CursoRepository;
import com.example.springbootEssentials.model.Estudante;
import com.example.springbootEssentials.model.EstudanteRepository;
import com.example.springbootEssentials.model.Matriculas;
import com.example.springbootEssentials.model.MatriculasRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/matricula")
@Slf4j
public class MatriculasController {
    @Autowired
    private MatriculasRepository matriculasRepository;
    @Autowired
    private EstudanteRepository estudanteRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping()
    public List<Matriculas> list() {
        log.info("Listando os matriculas.");
                 return matriculasRepository.findAll();
    }
    @GetMapping("/{id}")
    public Matriculas get(@PathVariable("id") Long id) throws BadRequestException{
        if(!Objects.isNull(id)){
            log.info("Listando o matricula: {}",id);
            
        }else{
            throw new BadRequestException();
        }
        return matriculasRepository.findById(id).get();
    }
    @PostMapping()
    public Matriculas save(@RequestBody Matriculas matricula)  throws BadRequestException{
        if(!Objects.isNull(matricula.getId()) && !Objects.isNull(matricula.getCurso())&& !Objects.isNull(matricula.getEstudante()) ){
            Estudante estudante = estudanteRepository.findById(matricula.getEstudante().getId()).get();
            Curso curso = cursoRepository.findById(matricula.getCurso().getId()).get();
            log.info("Cria a matricula do estudante: {} no curso {}",estudante.getNome(), curso.getTitulo());
            estudante.setDataMatricula(new Date().toString());
            estudanteRepository.save(estudante);
            log.info("Setada a data da matricula");
            matricula.setCurso(curso);
            log.info("Setado o curso");
            matricula.setEstudante(estudante);
            log.info("Setado o estudante");
            matriculasRepository.save(matricula);
            log.info("Salva a matricula");
            cursoRepository.save(curso);
            log.info("Salvo a matricula");
            estudanteRepository.save(estudante);
            log.info("Salvo o estudante");
            
        }else{
            throw new BadRequestException();
        }
        return matricula;
    }
    @PatchMapping("/{id}")
    public Matriculas update(@PathVariable ("id") Long id, @RequestBody Matriculas matricula) throws BadRequestException{
        if(!Objects.isNull(matricula.getId())){
            log.info("Atualiza o matricula: {}",matricula);
            
        }else{
            throw new BadRequestException();
        }
        return matriculasRepository.save(matricula);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Long id)  throws BadRequestException{
        if(!Objects.isNull(id)){
            log.info("Deleta o matricula: {}",id);
            
        }else{
            throw new BadRequestException();
        }
        matriculasRepository.deleteById(id);
    }

}
