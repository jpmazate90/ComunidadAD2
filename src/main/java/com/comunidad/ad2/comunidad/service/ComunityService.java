/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Comunity;
import java.io.IOException;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jesfrin
 */
public interface ComunityService {
    
    public Comunity save(Comunity comunity);
    
    public Optional<Comunity> findById(String id);
           
    public Iterable<Comunity> findAll();
    
    public Iterable<Comunity> getCommunitiesBySearch(String searchText);
        
    public Comunity guardarImagen(MultipartFile file) throws IOException;
    
    public boolean deleteById(String idComunidad);
    
}
