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
public class TokenCreatedTest {
    
    public TokenCreatedTest() {
    }
    
    

    /**
     * Test of getToken method, of class TokenCreated.
     */
    @Test
    public void testGetToken() {
        TokenCreated instance = instance();
        String expResult = "111111111";
        String result = instance.getToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setToken method, of class TokenCreated.
     */
    @Test
    public void testSetToken() {
        
        String token = "111111111";
        TokenCreated instance = instance();
        instance.setToken(token);
        assertEquals(token,instance.getToken());
        
    }
    
    public TokenCreated instance(){
        return new TokenCreated("111111111");
    }
    
}
