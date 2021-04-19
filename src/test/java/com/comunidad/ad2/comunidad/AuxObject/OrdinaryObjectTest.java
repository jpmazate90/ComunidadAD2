/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fabricio
 */
class OrdinaryObjectTest {

    public OrdinaryObjectTest() {
    }
    
    @Test
    void testGetNumberParam() {
        OrdinaryObject instance = instance();
        int numberParam = 1;
        int result = instance.getNumberParam();
        assertEquals(numberParam, result);
    }
    
    /**
     * Test of getIdComunidad method, of class ComunityAssignFilters.
     */
    @Test
    void testGetStringParam() {
        OrdinaryObject instance = instance();
        String stringParam = "stringParam";
        String result = instance.getStringParam();
        assertEquals(stringParam, result);
    }
    
    @Test
    void testGetDecimalParam() {
        OrdinaryObject instance = instance();
        double decimalParam = 1.5;
        double result = instance.getDecimalParam();
        assertEquals(decimalParam, result);
    }
    
    @Test
    void testGetTimeParam() {
        OrdinaryObject instance = instance();
        String timeParam = "timeParam";
        String result = instance.getTimeParam();
        assertEquals(timeParam, result);
    }
    
    @Test
    void testSetNumberParam() {
        OrdinaryObject instance = instance();
        int numberParam = 1;
        instance.setNumberParam(numberParam);
        assertEquals(numberParam, instance.getNumberParam());
    }
    
    @Test
    void testSetStringParam() {
        OrdinaryObject instance = instance();
        String stringParam = "stringParam";
        instance.setStringParam(stringParam);
        assertEquals(stringParam, instance.getStringParam());
    }

    @Test
    void testSetDecimalParam() {
        OrdinaryObject instance = instance();
        double decimalParam = 1.5;
        instance.setDecimalParam(decimalParam);
        assertEquals(decimalParam, instance.getDecimalParam());
    }
    
    @Test
    void testSetTimeParam() {
        OrdinaryObject instance = instance();
        String timeParam = "timeParam";
        instance.setTimeParam(timeParam);
        assertEquals(timeParam, instance.getTimeParam());
    }
    
    @Test
    void testOrdinaryObject(){
        OrdinaryObject ordinaryObject = new OrdinaryObject();
        assertEquals(ordinaryObject, ordinaryObject);
    }
    
    public OrdinaryObject instance(){
        return new OrdinaryObject(1, "stringParam", 1.5, "timeParam");
    }
    
}
