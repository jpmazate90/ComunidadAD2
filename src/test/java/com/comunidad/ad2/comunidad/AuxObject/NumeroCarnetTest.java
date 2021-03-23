/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

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
public class NumeroCarnetTest {
    
    public static final String NUMERO_DE_CARNET="12345678";
    public NumeroCarnet numeroCarnet;
    
    public NumeroCarnetTest() {
        this.numeroCarnet=new  NumeroCarnet(NUMERO_DE_CARNET);
    }
    

    /**
     * Test of getNumeroCarnet method, of class NumeroCarnet.
     */
    @Test
    public void testGetNumeroCarnet() {
        //Arrange
        System.out.println("getNumeroCarnet");
        NumeroCarnet instance = this.numeroCarnet;
        //Act
        String expResult = NUMERO_DE_CARNET;
        String result = instance.getNumeroCarnet();
        //Assert
        assertEquals(expResult, result);

    }

    /**
     * Test of setNumeroCarnet method, of class NumeroCarnet.
     */
    @Test
    public void testSetNumeroCarnet() {
        //Arrange
        System.out.println("setNumeroCarnet");
        NumeroCarnet instance = new NumeroCarnet();
        String nuevoCarnet ="8521478";
        //Act
        instance.setNumeroCarnet(nuevoCarnet);
        String expResult = nuevoCarnet;
        String result = instance.getNumeroCarnet();
        //Assert
        assertEquals(expResult, result);
    }
    
}
