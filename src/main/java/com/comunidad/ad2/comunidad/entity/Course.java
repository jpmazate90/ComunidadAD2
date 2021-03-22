/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jesfrin
 */
@Entity
@Table(name = "course")

public class Course implements Serializable {
        
    @Id
    @Column(name = "codigo_curso", length = 5)
    private String codigoDeCurso;
     
    @Column(name = "nombre_curso", length = 100,nullable = false)
    private String nombre;
    
   @Column(name ="no_de_semestre", nullable = false)
    private int noDeSemestre;

    public String getCodigoDeCurso() {
        return codigoDeCurso;
    }

    public void setCodigoDeCurso(String codigoDeCurso) {
        this.codigoDeCurso = codigoDeCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNoDeSemestre() {
        return noDeSemestre;
    }

    public void setNoDeSemestre(int noDeSemestre) {
        this.noDeSemestre = noDeSemestre;
    }

    public Course() {
    }

    public Course(String codigoDeCurso) {
        this.codigoDeCurso = codigoDeCurso;
    }

    public Course(String codigoDeCurso, String nombre, int noDeSemestre) {
        this.codigoDeCurso = codigoDeCurso;
        this.nombre = nombre;
        this.noDeSemestre = noDeSemestre;
    }

    
   
   
}
