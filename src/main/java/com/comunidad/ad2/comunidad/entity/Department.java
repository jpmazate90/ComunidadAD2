/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author jpmazate

*/

@Entity
@Table(name = "department")
public class Department implements Serializable {
    
    @Id
    @Column(name = "id_departamento",columnDefinition = "int AUTO_INCREMENT")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idDepartamento;
     
    
    @Column(name = "nombre_departamento", length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String nombre;

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    

     

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Department(Integer idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public Department(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Department() {
    }
    
   
    
   
   

}
