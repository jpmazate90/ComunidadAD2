/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jpmazate
 */
class CreacionUsuarioParaPruebasTest {
    
    public CreacionUsuarioParaPruebasTest() {
    }
    

    /**
     * Test of crearUsuario method, of class CreacionUsuarioParaPruebas.
     */
    @Test
    void testCrearUsuario() {
        RolUsuario a = RolUsuario.SUPER;
        User expResult = new User("201029301");
        User result = CreacionUsuarioParaPruebas.crearUsuario(a);
        assertEquals(expResult.getRegistroAcademico(), result.getRegistroAcademico());
    }
}
