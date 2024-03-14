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
import com.example.springbootEssentials.model.Estudante;
import com.example.springbootEssentials.model.EstudanteRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/estudante")
@Slf4j
public class EstudanteController {
    @Autowired
    private EstudanteRepository estudanteRepository;

    @GetMapping()
    public List<Estudante> list() {
        log.info("Listando os estudantes.");
                 return estudanteRepository.findAll();
    }
    @GetMapping("/{id}")
    public Estudante get(@PathVariable("id") Long id) throws BadRequestException{
        if(!Objects.isNull(id)){
            log.info("Listando o estudante: {}",id);
            
        }else{
            throw new BadRequestException();
        }
        return estudanteRepository.findById(id).get();
    }
    @PostMapping()
    public Estudante save(@RequestBody Estudante estudante)  throws BadRequestException{
        if(!Objects.isNull(estudante.getId())){
            log.info("Atualiza o estudante: {}",estudante);
            
        }else{
            throw new BadRequestException();
        }
        return estudanteRepository.save(estudante);
    }
    @PatchMapping("/{id}")
    public Estudante update(@PathVariable ("id") Long id, @RequestBody Estudante estudante) throws BadRequestException{
        if(!Objects.isNull(estudante.getId())){
            log.info("Atualiza o estudante: {}",estudante);
            
        }else{
            throw new BadRequestException();
        }
        return estudanteRepository.save(estudante);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Long id)  throws BadRequestException{
        if(!Objects.isNull(id)){
            log.info("Deleta o estudante: {}",id);
            
        }else{
            throw new BadRequestException();
        }
        estudanteRepository.deleteById(id);
    }

}
