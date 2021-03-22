/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
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
public class CreacionUsuarioParaPruebasTest {
    
    public CreacionUsuarioParaPruebasTest() {
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
     * Test of crearUsuario method, of class CreacionUsuarioParaPruebas.
     */
    @Test
    public void testCrearUsuario() {
        RolUsuario a = RolUsuario.SUPER;
        User expResult = new User("201029301");
        User result = CreacionUsuarioParaPruebas.crearUsuario(a);
        assertEquals(expResult.getRegistroAcademico(), result.getRegistroAcademico());
        
    }
    
}
