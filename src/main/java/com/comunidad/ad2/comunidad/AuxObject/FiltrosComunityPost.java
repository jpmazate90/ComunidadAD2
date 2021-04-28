/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

import com.comunidad.ad2.comunidad.service.enums.TipoValoracion;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author jpmazate
 */
public class FiltrosComunityPost {

    private int idComunidad;
    private String registroAcademico;
    private String fechaInicial;
    private String fechaFinal;
    private String usuario;
    private String valoracion;

    public FiltrosComunityPost(int idComunidad, String registroAcademico, String fechaInicial, String fechaFinal, String usuario, String valoracion) {
        this.idComunidad = idComunidad;
        this.registroAcademico = registroAcademico;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.usuario = usuario;
        this.valoracion = valoracion;
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

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

     

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

     

}
