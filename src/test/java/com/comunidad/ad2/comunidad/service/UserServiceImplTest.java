/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.UserRepository;
import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import com.comunidad.ad2.comunidad.service.enums.GeneroUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.sql.Timestamp;
//import static org.junit.Assert.assertEquals;


//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jpmazate
 */
//@RunWith(MockitoJUnitRunner.class)

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;  // es el mock

    @InjectMocks
    private UserServiceImpl userService; // es la implementacion

    public UserServiceImplTest() {
    }

    /**
     * Test of findAll method, of class UserServiceImpl.
     */
    //@Test
    public void testSave() {
        // arrange
        User usuario = crearUsuario(RolUsuario.SUPER);
        //UserServiceImpl userService = Mockito.mock(new UserServiceImpl(userRepository));
        System.out.println(userService);
            
        Mockito.when(userService.hashearContrasena(usuario)).thenReturn("xxxxx");
        
        //act
        User resultado =  userService.save(usuario);
        //assert
        //assertEquals("xxxxx",resultado.getPassword());
    }
    
    private User crearUsuario(RolUsuario a){
        User user = new User("201029301","aaa", "aaa", new Timestamp(400000000), GeneroUsuario.N, "aa", "aa@a.com", a, "xela", EstadoUsuario.ACTIVO);
        return user;
    }

    /**
     * Test of deleteById method, of class UserServiceImpl.
     */
    /**
     * Test of formatearFecha method, of class UserServiceImpl.
     */
//    @Test
//    public void testFormatearFecha() {
//        System.out.println("formatearFecha");
//        User user = null;
//        UserServiceImpl instance = null;
//        Timestamp expResult = null;
//        Timestamp result = instance.formatearFecha(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hashearContrasena method, of class UserServiceImpl.
//     */
//    @Test
//    public void testHashearContrasena() {
//        System.out.println("hashearContrasena");
//        User user = null;
//        UserServiceImpl instance = null;
//        String expResult = "";
//        String result = instance.hashearContrasena(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of asignarEstado method, of class UserServiceImpl.
//     */
//    @Test
//    public void testAsignarEstado() {
//        System.out.println("asignarEstado");
//        User user = null;
//        UserServiceImpl instance = null;
//        instance.asignarEstado(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
