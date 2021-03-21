/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.repository.ComunityAssignRepository;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jesfrin
 */
@Service
public class ComunityAssignImpl implements ComunityAssignService {

    private ComunityAssignRepository comunityAssignRepository;

    @Autowired
    public ComunityAssignImpl(ComunityAssignRepository comunityAssignRepository) {
        this.comunityAssignRepository = comunityAssignRepository;
    }

    @Override
    public ComunityAssign save(ComunityAssign comunityAssign) {
        //Asignando la fecha de creacion de la comunidad
        comunityAssign.setFechaCreacion(getFechaActual());
        return this.comunityAssignRepository.save(comunityAssign);
    }

    @Override
    public Optional<ComunityAssign> findByIdComunity(int idComunidad) {
        return this.comunityAssignRepository.findByIdComunity(idComunidad);
    }

    @Override
    public Iterable<ComunityAssign> findByRegistroAcademico(String registroAcademico) {
        return this.comunityAssignRepository.findByRegistroAcademico(registroAcademico);
    }

    @Override
    public Optional<ComunityAssign> findByIdComunityMiembro(int idComunidad,String registroAcademico) {
        return this.comunityAssignRepository.findByIdComunityMiembro(idComunidad,registroAcademico);
    }

    public Timestamp getFechaActual() {
        Date fecha = new Date();
        return new Timestamp(fecha.getTime());
    }

}
