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
 * @author jpmazate
 */
public class FiltrosComunityPostTest {
    
    public FiltrosComunityPostTest() {
    }
    
    
    /**
     * Test of getRegistroAcademico method, of class FiltrosComunityPost.
     */
    @Test
    public void testGetRegistroAcademico() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String expResult = "1";
        String result = instance.getRegistroAcademico();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setRegistroAcademico method, of class FiltrosComunityPost.
     */
    @Test
    public void testSetRegistroAcademico() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String registroAcademico = "5";
        instance.setRegistroAcademico(registroAcademico);
        assertEquals(registroAcademico,instance.getRegistroAcademico());
    }

    /**
     * Test of getIdComunidad method, of class FiltrosComunityPost.
     */
    @Test
    public void testGetIdComunidad() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        int idComunidad = 1;
        int result = instance.getIdComunidad();
        assertEquals(idComunidad,result);
        
    }

    /**
     * Test of setIdComunidad method, of class FiltrosComunityPost.
     */
    @Test
    public void testSetIdComunidad() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        int idComunidad = 1;
        instance.setIdComunidad(idComunidad);
        assertEquals(idComunidad,instance.getIdComunidad());
    }

    /**
     * Test of getFechaInicial method, of class FiltrosComunityPost.
     */
    @Test
    public void testGetFechaInicial() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String fechaInicial = "1";
        String result = instance.getFechaInicial();
        assertEquals(fechaInicial,result);
    }

    /**
     * Test of setFechaInicial method, of class FiltrosComunityPost.
     */
    @Test
    public void testSetFechaInicial() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String fechaInicial = "1";
        instance.setFechaInicial(fechaInicial);
        assertEquals(fechaInicial,instance.getFechaInicial());
    }

    /**
     * Test of getFechaFinal method, of class FiltrosComunityPost.
     */
    @Test
    public void testGetFechaFinal() {
       String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String fechaFinal = "1";
        String result = instance.getFechaFinal();
        assertEquals(fechaFinal,result);
    }

    /**
     * Test of setFechaFinal method, of class FiltrosComunityPost.
     */
    @Test
    public void testSetFechaFinal() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String fechaFinal = "1";
        instance.setFechaFinal(fechaFinal);
        assertEquals(fechaFinal,instance.getFechaFinal());
    }

    /**
     * Test of getUsuario method, of class FiltrosComunityPost.
     */
    @Test
    public void testGetUsuario() {
        
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String usuario = "1";
        String result = instance.getUsuario();
        assertEquals(usuario,result);
    }

    /**
     * Test of setUsuario method, of class FiltrosComunityPost.
     */
    @Test
    public void testSetUsuario() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String usuario = "1";
        instance.setUsuario(usuario);
        assertEquals(usuario,instance.getUsuario());
    }

    /**
     * Test of getValoracion method, of class FiltrosComunityPost.
     */
    @Test
    public void testGetValoracion() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String valoracion = "1";
        String result = instance.getValoracion();
        assertEquals(valoracion,result);
    }

    /**
     * Test of setValoracion method, of class FiltrosComunityPost.
     */
    @Test
    public void testSetValoracion() {
        String s = "1";
        FiltrosComunityPost instance = new FiltrosComunityPost(1, s,s,s, s, s);
        String valoracion = "1";
        instance.setValoracion(valoracion);
        assertEquals(valoracion,instance.getValoracion());
    }
    
}
