/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jesfrin
 */
@Embeddable
public class ComunityAssignKey implements Serializable{
    
    @Column(name = "registro_adademico")
    private String registroAcademico;    

    @Column(name = "id_comunity")
    private int idComunidad;

    public ComunityAssignKey() {
    }

    public ComunityAssignKey(String registroAcademico, int idComunidad) {
        this.registroAcademico = registroAcademico;
        this.idComunidad = idComunidad;
    }

    public String getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }

    public int getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(int idComunidad) {
        this.idComunidad = idComunidad;
    }


    
    
}
