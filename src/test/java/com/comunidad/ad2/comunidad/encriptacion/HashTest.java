/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.encriptacion;

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
public class HashTest {
    
    public HashTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getHash method, of class Hash.
     */
    @Test
    public void testGetHash() {
        System.out.println("getHash");
        String txt = "1";
        String hashType = "MD5";
        String expResult = "c4ca4238a0b923820dcc509a6f75849b";
        String result = Hash.getHash(txt, hashType);
        assertEquals(expResult, result);
        
    }
    
        /**
     * Test of getHash method, of class Hash.
     */
    @Test
    public void testGetHashWithError() {
        Hash hash = new Hash();
        System.out.println("getHash");
        String txt = "1";
        String hashType = "aaa";
        String expResult = null;
        String result = Hash.getHash(txt, hashType);
        assertEquals(expResult, result);
        
    }


    /**
     * Test of md5 method, of class Hash.
     */
    @Test
    public void testMd5() {
         String txt = "1";
        String expResult = "c4ca4238a0b923820dcc509a6f75849b";
        String result = Hash.md5(txt);
        assertEquals(expResult, result);
        
    }
    
}
