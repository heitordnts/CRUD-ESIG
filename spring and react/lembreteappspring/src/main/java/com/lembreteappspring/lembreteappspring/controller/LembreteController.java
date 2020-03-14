/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lembreteappspring.lembreteappspring.controller;

import com.lembreteappspring.lembreteappspring.model.Lembrete;
import com.lembreteappspring.lembreteappspring.repository.LembreteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author heitor
 */
@RestController
@RequestMapping(value="/api")
@CrossOrigin(value = "*")
public class LembreteController {
    @Autowired
    private LembreteRepository lembreteRepo;
    
    @GetMapping("/l")
    public List<Lembrete> getLembretes(){
        
        return lembreteRepo.findAll();
    }
    
    @PostMapping(path="/l", consumes = "application/json", produces = "application/json")
    public Lembrete addLembrete(@RequestBody Lembrete l){
//        if(!l.getTexto().isEmpty()){
        System.out.println(l+"POST");
          return lembreteRepo.save(l);
//        }
    }
    
    @DeleteMapping(path="/l")
    public void removeLembrete(@RequestBody Lembrete l){
//        if(!l.getTexto().isEmpty()){
        System.out.println(l+"DELETE");
         lembreteRepo.delete(l);
//        }
    }
    @PutMapping(path="/l", consumes = "application/json", produces = "application/json")
    public Lembrete updateLembrete(@RequestBody Lembrete l){
//        if(!l.getTexto().isEmpty()){
        System.out.println(l+"POST");
          return lembreteRepo.save(l);
//        }
    }

}
