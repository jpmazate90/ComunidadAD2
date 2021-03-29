/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.repository.ComunityAssignRepository;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;

    @Autowired
    public ComunityAssignImpl(ComunityAssignRepository comunityAssignRepository) {
        this.comunityAssignRepository = comunityAssignRepository;
        this.recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
    }

    /**
     * Permite guardar un AssignComunity
     *
     * @param comunityAssign
     * @return
     */
    @Override
    public ComunityAssign save(ComunityAssign comunityAssign) {
        //Asignando la fecha de creacion de la comunidad
        comunityAssign.setFechaCreacion(getFechaActual());
        return this.comunityAssignRepository.save(comunityAssign);
    }

    /**
     * Permite buscar todas las comunidades que haya creado un usario COMUNIDAD
     * o SUPER
     *
     * @param registroAcademico
     * @return
     */
    @Override
    public Iterable<ComunityAssign> findComunityTypeAdminitrationByRegistroAcademico(String registroAcademico) {
        Iterable<ComunityAssign> comunidadesAsignadas = this.comunityAssignRepository.findComunityTypeAdminitrationByRegistroAcademico(registroAcademico);
        for (ComunityAssign comunidadesAsignada : comunidadesAsignadas) {
            agregarFotoAComunidad(comunidadesAsignada);
        }
        return comunidadesAsignadas;
    }

    /**
     * Devuelve la comunidad indicada si es que el usuario es dueño osea
     * Administrador
     *
     * @param idComunidad
     * @return
     */
    @Override
    public Optional<ComunityAssign> findComunityOwnerByIdComunity(int idComunidad) {
        Optional<ComunityAssign> comunityFind = this.comunityAssignRepository.findComunityOwnerByIdComunity(idComunidad);
        if (comunityFind.isPresent()) {
            agregarFotoAComunidad(comunityFind.get());
        }
        return comunityFind;
    }

    /**
     * Devulve la comunidad indicada si el usuario es Miembro de la comunidad
     * Miembro no importando si esta en ESPERA, DENEGADO o Aceptado
     *
     * @param idComunidad
     * @param registroAcademico
     * @return
     */
    @Override
    public Optional<ComunityAssign> findByIdComunityMiembro(int idComunidad, String registroAcademico) {
        return this.comunityAssignRepository.findByIdComunityMiembro(idComunidad, registroAcademico);
    }

    public Timestamp getFechaActual() {
        Date fecha = new Date();
        return new Timestamp(fecha.getTime());
    }

    public ComunityAssign agregarFotoAComunidad(ComunityAssign comunityAssign) {
        String foto;
        byte[] datosFoto;
        if (comunityAssign.getComunity().getFoto() != null) {
            foto = comunityAssign.getComunity().getFoto();
            datosFoto = this.recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(foto);
            comunityAssign.getComunity().setDatosFoto(datosFoto);
        }
        return comunityAssign;
    }
    
    @Override
    public Iterable<ComunityAssign> findRequestInEspera(Integer idComunidad, String registroAcademico) {
        return this.comunityAssignRepository.findUserRequest(idComunidad,registroAcademico+"");
    }

    @Override
    public ComunityAssign updateStateComunityRequest(ComunityAssign comunityAssign) {
        comunityAssign.setFecha_decision(getFechaActual());
        return this.comunityAssignRepository.save(comunityAssign);

    }

    @Override
    public Iterable<ComunityAssign> findUserComunitys(String registroAcademicoDeUsuario) {
        Iterable<ComunityAssign> comunidades=this.comunityAssignRepository.findUserComunitys(registroAcademicoDeUsuario);
        for (ComunityAssign comunidad : comunidades) {
            agregarFotoAComunidad(comunidad);
        }
        return comunidades;
    }



}
