/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author jesfrin
 */
@Entity
@Table(name = "comunity")
public class Comunity {
    
    
    @Id
    @Column(name = "id_comunity")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne//Un curso puede estar en varias comunidades 
    private Course course;
    
    @ManyToOne //Un suario tendra varias comunidades
    private User user;
    
    @Column(name = "nombre_comunidad", length = 100,nullable = false)
    private String nombre;
    
    @Column(name = "descripcion_comunidad", length = 100)
    private String descripcion;
    
    @Column(name = "foto_comunidad", length = 100)
    @Type(type = "text")
    private String foto;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    
    
    
}
