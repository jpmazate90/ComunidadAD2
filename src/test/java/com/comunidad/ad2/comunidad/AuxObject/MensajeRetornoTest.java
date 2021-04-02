/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

import static com.comunidad.ad2.comunidad.AuxObject.NumeroCarnetTest.NUMERO_DE_CARNET;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jpmazate
 */
public class MensajeRetornoTest {
    
    public static final String MENSAJE="HOLA";
    public MensajeRetorno mensajeRetorno;
    
    public MensajeRetornoTest() {
        this.mensajeRetorno = new MensajeRetorno(MENSAJE);
    }
    

    /**
     * Test of getMensaje method, of class MensajeRetorno.
     */
    @Test
    public void testGetMensaje() {
       //Arrange
        MensajeRetorno instance = this.mensajeRetorno;
        //Act
        String expResult = MENSAJE;
        String result = instance.getMensaje();
        //Assert
        assertEquals(expResult, result);
    }

    /**
     * Test of setMensaje method, of class MensajeRetorno.
     */
    @Test
    public void testSetMensaje() {
        //Arrange
        MensajeRetorno instance = new MensajeRetorno(MENSAJE);
        String nuevoMensaje ="PRUEBA";
        //Act
        instance.setMensaje(nuevoMensaje);
        String expResult = nuevoMensaje;
        String result = instance.getMensaje();
        //Assert
        assertEquals(expResult, result);
    }
    
}