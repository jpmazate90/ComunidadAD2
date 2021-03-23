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
public class ComunityAssignKeyTest {
    
    private ComunityAssignKey comunityAssignKey;
    public static final String REGISTRO_ACADEMICO="12345678";
    public static final int ID_COMUNIDAD=1;
    
    public ComunityAssignKeyTest() {
        this.comunityAssignKey = new ComunityAssignKey(REGISTRO_ACADEMICO,ID_COMUNIDAD);
    }


    /**
     * Test of getRegistroAcademico method, of class ComunityAssignKey.
     */
    @Test
    public void testGetRegistroAcademico() {
        //Act
        System.out.println("getRegistroAcademico");
        ComunityAssignKey instance = this.comunityAssignKey;
        //Arrange
        String expResult = REGISTRO_ACADEMICO;
        String result = instance.getRegistroAcademico();
        //Arrange
        assertEquals(expResult, result);
 
    }

    /**
     * Test of setRegistroAcademico method, of class ComunityAssignKey.
     */
    @Test
    public void testSetRegistroAcademico() {
        //Act
        System.out.println("setRegistroAcademico");
        ComunityAssignKey instance = this.comunityAssignKey;
        String nuevoRegistroAcademico = "31425";
        //Arrange
        instance.setRegistroAcademico(nuevoRegistroAcademico);
        String expResult = nuevoRegistroAcademico;
        String result = instance.getRegistroAcademico();
        //Arrange
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdComunidad method, of class ComunityAssignKey.
     */
    @Test
    public void testGetIdComunidad() {
        //Act
        System.out.println("getIdComunidad");
        ComunityAssignKey instance = this.comunityAssignKey;
        //Arrange
        int expResult = ID_COMUNIDAD;
        int result = instance.getIdComunidad();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setIdComunidad method, of class ComunityAssignKey.
     */
    @Test
    public void testSetIdComunidad() {
        //Act
        System.out.println("getIdComunidad");
        ComunityAssignKey instance = this.comunityAssignKey;
        int nuevoIdComunidad=5;
        //Arrange
        instance.setIdComunidad(nuevoIdComunidad);
        int expResult = nuevoIdComunidad;
        int result = instance.getIdComunidad();
        //Assert
        assertEquals(expResult, result);
    }
    
}
