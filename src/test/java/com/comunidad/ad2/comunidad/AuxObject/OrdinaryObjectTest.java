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
public class OrdinaryObjectTest {

    public OrdinaryObjectTest() {
    }
    
    @Test
    public void testGetNumberParam() {
        OrdinaryObject instance = instance();
        int numberParam = 1;
        int result = instance.getNumberParam();
        assertEquals(numberParam, result);
    }
    
    /**
     * Test of getIdComunidad method, of class ComunityAssignFilters.
     */
    @Test
    public void testGetStringParam() {
        OrdinaryObject instance = instance();
        String stringParam = "stringParam";
        String result = instance.getStringParam();
        assertEquals(stringParam, result);
    }
    
    @Test
    public void testGetDecimalParam() {
        OrdinaryObject instance = instance();
        double decimalParam = 1.5;
        double result = instance.getDecimalParam();
        assertEquals(decimalParam, result);
    }
    
    @Test
    public void testGetTimeParam() {
        OrdinaryObject instance = instance();
        String timeParam = "timeParam";
        String result = instance.getTimeParam();
        assertEquals(timeParam, result);
    }
    
    @Test
    public void testSetNumberParam() {
        OrdinaryObject instance = instance();
        int numberParam = 1;
        instance.setNumberParam(numberParam);
        assertEquals(numberParam, instance.getNumberParam());
    }
    
    @Test
    public void testSetStringParam() {
        OrdinaryObject instance = instance();
        String stringParam = "stringParam";
        instance.setStringParam(stringParam);
        assertEquals(stringParam, instance.getStringParam());
    }

    @Test
    public void testSetDecimalParam() {
        OrdinaryObject instance = instance();
        double decimalParam = 1.5;
        instance.setDecimalParam(decimalParam);
        assertEquals(decimalParam, instance.getDecimalParam());
    }
    
    @Test
    public void testSetTimeParam() {
        OrdinaryObject instance = instance();
        String timeParam = "timeParam";
        instance.setTimeParam(timeParam);
        assertEquals(timeParam, instance.getTimeParam());
    }
    
    @Test
    public void testOrdinaryObject(){
        OrdinaryObject ordinaryObject = new OrdinaryObject();
        assertEquals(ordinaryObject, ordinaryObject);
    }
    
    public OrdinaryObject instance(){
        return new OrdinaryObject(1, "stringParam", 1.5, "timeParam");
    }
    
}
