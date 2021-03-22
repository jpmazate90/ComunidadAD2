/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

import java.sql.Timestamp;

/**
 *
 * @author jpmazate
 */
public class ComunityAssignFilters {
    //aqui se podrian agregar mas filtros de ser necesarios
    private String registroAcademico;
    private Integer idComunidad;

    
    
    public ComunityAssignFilters(String registroAcademico, Integer idComunidad) {
        this.registroAcademico = registroAcademico;
        this.idComunidad = idComunidad;
    }

    public Integer getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(Integer idComunidad) {
        this.idComunidad = idComunidad;
    }


    
    
    public ComunityAssignFilters(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }

    public ComunityAssignFilters() {
    }

    public String getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }
    
    
    

    @Override
    public String toString() {
        return "ComunityAssignFilters{" + "registroAcademico=" + registroAcademico + '}';
    }
    
    
    
}
