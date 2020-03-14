/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lembreteappspring.lembreteappspring.repository;

import com.lembreteappspring.lembreteappspring.model.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author heitor
 */
@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Long>{
    
}
