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
public class ComunityAssignFiltersTest {
    
    public ComunityAssignFiltersTest() {
    }
    

    /**
     * Test of getIdComunidad method, of class ComunityAssignFilters.
     */
    @Test
    public void testGetIdComunidad() {
        ComunityAssignFilters instance = instance();
        Integer expResult = 4;
        Integer result = instance.getIdComunidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdComunidad method, of class ComunityAssignFilters.
     */
    @Test
    public void testSetIdComunidad() {
        Integer idComunidad = 4;
        ComunityAssignFilters instance = new ComunityAssignFilters();
        
        instance.setIdComunidad(idComunidad);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(idComunidad, instance.getIdComunidad());
    }

    /**
     * Test of getRegistroAcademico method, of class ComunityAssignFilters.
     */
    @Test
    public void testGetRegistroAcademico() {
        System.out.println("getRegistroAcademico");
        ComunityAssignFilters instance = instance();
        String expResult = "111111111";
        String result = instance.getRegistroAcademico();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegistroAcademico method, of class ComunityAssignFilters.
     */
    @Test
    public void testSetRegistroAcademico() {
        String registroAcademico = "111111111";
        ComunityAssignFilters instance = new ComunityAssignFilters();
        
        instance.setRegistroAcademico(registroAcademico);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(registroAcademico, instance.getRegistroAcademico());
    }

    /**
     * Test of toString method, of class ComunityAssignFilters.
     */
    @Test
    public void testToString() {
        ComunityAssignFilters instance = instance();
        String expResult = "ComunityAssignFilters{" + "registroAcademico=" + "111111111" + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void ComunityAssignFiltersTest() {
        
        ComunityAssignFilters a = new ComunityAssignFilters("1");
        String registroAcademico ="1";
        assertEquals(registroAcademico, a.getRegistroAcademico());
    }
    
    public ComunityAssignFilters instance(){
        return new ComunityAssignFilters("111111111", 4);
    }
    
}
