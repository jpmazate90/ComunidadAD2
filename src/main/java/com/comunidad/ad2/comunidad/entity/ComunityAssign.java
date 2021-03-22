/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.EstadoComunityAssign;
import com.comunidad.ad2.comunidad.service.enums.TipoComunityAssign;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author jesfrin
 */
@Entity
@Table(name = "comunity_assign")
public class ComunityAssign implements Serializable {

    public ComunityAssign() {
    }

    public ComunityAssign(ComunityAssignKey id, User user, Comunity comunity, TipoComunityAssign tipo, Timestamp fecha_decision, EstadoComunityAssign estado, Timestamp fechaCreacion_O_Aceptacion) {
        this.idComunityAssign = id;
        this.user = user;
        this.comunity = comunity;
        this.tipo = tipo;
        this.fecha_decision = fecha_decision;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion_O_Aceptacion;
    }

    public ComunityAssign(ComunityAssignKey idComunityAssign, TipoComunityAssign tipo, Timestamp fecha_decision, EstadoComunityAssign estado, Timestamp fechaCreacion) {
        this.idComunityAssign = idComunityAssign;
        this.tipo = tipo;
        this.fecha_decision = fecha_decision;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;//Cabiar nombre a fecha_creacion
    }

    public ComunityAssign(TipoComunityAssign tipo,EstadoComunityAssign estado,Timestamp fecha_decision, Timestamp fechaCreacion) {
       // this.idComunityAssign = idComunityAssign;
        this.fecha_decision = fecha_decision;
        this.fechaCreacion = fechaCreacion;
        this.tipo=tipo;
        this.estado=estado;
    }

    
    
    
    @EmbeddedId
    private ComunityAssignKey idComunityAssign;

    @ManyToOne
    @MapsId("registroAcademico")
    private User user;
    
    @ManyToOne
    @MapsId("idComunidad")
    private Comunity comunity;
    
    @Column(name = "tipo_assign", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoComunityAssign tipo;

    @Column(name = "fecha_decision", nullable = true)
    private Timestamp fecha_decision;//Guarda la fecha cuando se acepto o se denego una solicitud

    @Column(name = "estado_solicitud", nullable = true)
    @Enumerated(EnumType.STRING)
    private EstadoComunityAssign estado;

    @Column(name = "fecha_creacion", nullable = true)
    private Timestamp fechaCreacion;

    public ComunityAssignKey getIdComunityAssign() {
        return idComunityAssign;
    }

    public void setIdComunityAssign(ComunityAssignKey idComunityAssign) {
        this.idComunityAssign = idComunityAssign;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comunity getComunity() {
        return comunity;
    }

    public void setComunity(Comunity comunity) {
        this.comunity = comunity;
    }

    public TipoComunityAssign getTipo() {
        return tipo;
    }

    public void setTipo(TipoComunityAssign tipo) {
        this.tipo = tipo;
    }

    public Timestamp getFecha_decision() {
        return fecha_decision;
    }

    public void setFecha_decision(Timestamp fecha_decision) {
        this.fecha_decision = fecha_decision;
    }

    public EstadoComunityAssign getEstado() {
        return estado;
    }

    public void setEstado(EstadoComunityAssign estado) {
        this.estado = estado;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

 

    @Override
    public String toString() {
        return "ComunityAssign{" + "registro,id=" + idComunityAssign.getRegistroAcademico() +"  "+idComunityAssign.getIdComunidad()+ ", user=" + user + ", comunity=" + comunity + ", tipo=" + tipo + ", fecha_decision=" + fecha_decision + ", estado=" + estado + ", fechaCreacion_O_Aceptacion=" + fechaCreacion + '}';
    }

    
   
}
