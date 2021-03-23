/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Comunity;
import java.util.Optional;

/**
 *
 * @author jesfrin
 */
public interface ComunityService {
    
    //    public User save(User user); 
    public Comunity save(Comunity comunity);
       
//    public Iterable<Comunity> findByRegistroAcademico(String user);
    
    public Optional<Comunity> findById(Integer idComunidad);
    
    public Iterable<Comunity> findAll();
    
    public Iterable<Comunity> getCommunitiesBySearch(String searchText);
    
}
