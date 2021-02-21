/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import com.comunidad.ad2.comunidad.service.enums.GeneroUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author jpmazate
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    
    //private static final long serialVersioinUID = -9069060843698080433L;
    
     @Id
    @Column(name = "registroAcademico", length = 9)
    private String registroAcademico;

    @Column(name = "nombreCompleto", length = 200, nullable = false)
    private String nombreCompleto;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "fechaDeNacimiento", nullable = false)
    private Timestamp fechaDeNacimiento;

    @Column(name = "genero", nullable = false)
    @Enumerated(EnumType.STRING)
    private GeneroUsuario genero;

    @Column(name = "fotoDePerfil", nullable = false)
    @Type(type = "text")
    private String fotoDePerfil;

    @Column(name = "correoElectronico", length = 45, nullable = false)
    private String correoElectronico;

    @Column(name = "rol", nullable = false)
    @Enumerated(EnumType.STRING)
    private RolUsuario rolUsuario;

    @Column(name = "ciudad", length = 45, nullable = false)
    private String ciudad;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;
    
    @Column(name = "token",length = 255, nullable = true)
    private String token;
    
    

    public User(String registroAcademico, String nombreCompleto, String password, Timestamp fechaDeNacimiento, GeneroUsuario genero, String fotoDePerfil, String correoElectronico, RolUsuario rolUsuario, String ciudad, EstadoUsuario estado) {
        this.registroAcademico = registroAcademico;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.genero = genero;
        this.fotoDePerfil = fotoDePerfil;
        this.correoElectronico = correoElectronico;
        this.rolUsuario = rolUsuario;
        this.ciudad = ciudad;
        this.estado = estado;
        
    }

     
    
    public User(){
        
    }

    public User(String registroAcademico, String password) {
        this.registroAcademico = registroAcademico;
        this.password = password;
    }
    
    

    public String getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Timestamp fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public GeneroUsuario getGenero() {
        return genero;
    }

    public void setGenero(GeneroUsuario genero) {
        this.genero = genero;
    }

    public String getFotoDePerfil() {
        return fotoDePerfil;
    }

    public void setFotoDePerfil(String fotoDePerfil) {
        this.fotoDePerfil = fotoDePerfil;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    
    
   

    
    
    
    
}
