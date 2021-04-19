/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.Visibilidad;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;

/**
 *
 * @author jesfrin
 */
@Entity
@Table(name = "comunity")
public class Comunity implements Serializable {

    public Comunity(Course course, String nombre, String descripcion) {
        this.course = course;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Comunity(int id, Course course, String nombre, String descripcion, String foto) {
        this.id = id;
        this.course = course;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
    }
    
    public Comunity(int id, Course course, String nombre, String descripcion, String foto,Visibilidad privacidad) {
        this.id = id;
        this.course = course;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.privacidad = privacidad;
    }

    public Comunity(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_comunity")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne//Un curso puede estar en varias comunidades 
    private Course course;

    @Column(name = "nombre_comunidad", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion_comunidad", length = 100)
    private String descripcion;

    @Column(name = "foto_comunidad", length = 100)
    @Type(type = "text")
    private String foto;

    @JsonInclude
    @Transient
    private byte[] datosFoto;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "privacidad", length = 20, columnDefinition = "varchar(20) default 'PUBLICO'")
    private Visibilidad privacidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Comunity() {
    }

    public byte[] getDatosFoto() {
        return datosFoto;
    }

    public void setDatosFoto(byte[] datosFoto) {
        this.datosFoto = datosFoto;
    }

    public Visibilidad getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(Visibilidad privacidad) {
        this.privacidad = privacidad;
    }
    
    

    @Override
    public String toString() {
        return "Comunity{" + "id=" + id + ", course=" + course + ", nombre=" + nombre + ", descripcion=" + descripcion + ", foto=" + foto + ", datosFoto=" + datosFoto + '}';
    }

}
