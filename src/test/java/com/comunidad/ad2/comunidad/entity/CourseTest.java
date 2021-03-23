/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jesfrin
 */
public class CourseTest {
    
    public static final String CODIGO_DE_CURSO="001";
    public static final String NOMBRE="Matematica";
    public static final int NO_SEMESTRE=1;
    private Course curso;
    
    public CourseTest() {
        this.curso= new Course(CODIGO_DE_CURSO,NOMBRE,NO_SEMESTRE);
    }

    /**
     * Test of getCodigoDeCurso method, of class Course.
     */
    @Test
    public void testGetCodigoDeCurso() {
        //Act
        System.out.println("getCodigoDeCurso");
        Course instance = this.curso;
        //Arrange
        String expResult = CODIGO_DE_CURSO;
        String result = instance.getCodigoDeCurso();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of setCodigoDeCurso method, of class Course.
     */
    @Test
    public void testSetCodigoDeCurso() {
        //Act
        System.out.println("setCodigoDeCurso");
        Course instance = this.curso;
        String nuevoCodigoDeCurso="002";
        //Arrange
        instance.setCodigoDeCurso(nuevoCodigoDeCurso);
        String expResult = nuevoCodigoDeCurso;
        String result = instance.getCodigoDeCurso();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class Course.
     */
    @Test
    public void testGetNombre() {
        //Act
        System.out.println("getNombre");
        Course instance = this.curso;
        //Arrnge
        String expResult = NOMBRE;
        String result = instance.getNombre();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setNombre method, of class Course.
     */
    @Test
    public void testSetNombre() {
        //Act
        System.out.println("setNombre");
        Course instance = this.curso;
        String nuevoNombre = "Sociales";
        //Arrnge
        instance.setNombre(nuevoNombre);
        String expResult = nuevoNombre;
        String result = instance.getNombre();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of getNoDeSemestre method, of class Course.
     */
    @Test
    public void testGetNoDeSemestre() {
        //Act
        System.out.println("getNoDeSemestre");
        Course instance = this.curso;
        //Arrange
        int expResult = NO_SEMESTRE;
        int result = instance.getNoDeSemestre();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setNoDeSemestre method, of class Course.
     */
    @Test
    public void testSetNoDeSemestre() {
        //Act
        System.out.println("setNoDeSemestre");
        Course instance = this.curso;
        int nuevoNumeroDeSemestre=2;
        //Arrange
        instance.setNoDeSemestre(nuevoNumeroDeSemestre);
        int expResult = nuevoNumeroDeSemestre;
        int result = instance.getNoDeSemestre();
        //Assert
        assertEquals(expResult, result);

    }
    
}
