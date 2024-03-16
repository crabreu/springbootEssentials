package com.example.springbootEssentials.controller;


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
import com.example.springbootEssentials.model.Matriculas;
import com.example.springbootEssentials.model.MatriculasRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/matricula")
@Slf4j
public class MatriculasController {
    @Autowired
    private MatriculasRepository matriculasRepository;

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
        if(!Objects.isNull(matricula.getId())){
            log.info("Cria a matricula: {}",matricula);
            
        }else{
            throw new BadRequestException();
        }
        return matriculasRepository.save(matricula);
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
