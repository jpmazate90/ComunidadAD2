/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jpmazate
 */
class ComunityAssignFiltersTest {
    
    public ComunityAssignFiltersTest() {
    }
    

    /**
     * Test of getIdComunidad method, of class ComunityAssignFilters.
     */
    @Test
    void testGetIdComunidad() {
        ComunityAssignFilters instance = instance();
        Integer expResult = 4;
        Integer result = instance.getIdComunidad();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdComunidad method, of class ComunityAssignFilters.
     */
    @Test
    void testSetIdComunidad() {
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
    void testGetRegistroAcademico() {
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
    void testSetRegistroAcademico() {
        String registroAcademico = "111111111";
        ComunityAssignFilters instance = new ComunityAssignFilters();
        instance.setRegistroAcademico(registroAcademico);
        assertEquals(registroAcademico, instance.getRegistroAcademico());
    }

    @Test
    void ComunityAssignFiltersTest() {
        ComunityAssignFilters a = new ComunityAssignFilters("1");
        String registroAcademico ="1";
        assertEquals(registroAcademico, a.getRegistroAcademico());
    }
    
    @Test
    void ComunityAssignFiltersTestGetState() {
        ComunityAssignFilters a = new ComunityAssignFilters("1","a",1);
        String state ="a";
        assertEquals(state, a.getStateAssign());
    }
    
    @Test
    void ComunityAssignFiltersTestSetState() {
        ComunityAssignFilters a = new ComunityAssignFilters("1","a",1);
        String state ="b";
        a.setStateAssign(state);
        assertEquals(state, a.getStateAssign());
    }
    
    @Test
    void ComunityAssignFiltersTestToString() {
        ComunityAssignFilters a = new ComunityAssignFilters("1","a",1);
        String string ="ComunityAssignFilters{" + "registroAcademico=" + "1" + ", stateAssign=" + "a" + ", idComunidad=" + 1 + '}';
        String result = a.toString();
        assertEquals(result,string);
    }
    
    public ComunityAssignFilters instance(){
        return new ComunityAssignFilters("111111111", 4);
    }
    
}
