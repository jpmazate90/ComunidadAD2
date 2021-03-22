/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.ComunityRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jesfrin
 */
@Service
public class ComunityImpl implements ComunityService {

    private ComunityRepository comunityRepository;

    @Autowired
    public ComunityImpl(ComunityRepository comunityRepository) {
        this.comunityRepository = comunityRepository;
    }

    @Override
    public Comunity save(Comunity comunity) {
        return this.comunityRepository.save(comunity);
    }

//    @Override
//    public Iterable<Comunity> findByRegistroAcademico(String registroAcademico) {
//        return this.comunityRepository.findByRegistroAcademico(registroAcademico);
//    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comunity> findById(Integer idComunidad) {
        return this.comunityRepository.findById(idComunidad);
    }

}
