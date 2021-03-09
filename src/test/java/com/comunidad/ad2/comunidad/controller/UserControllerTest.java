/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jpmazate
 */
public class UserControllerTest {
    
    public UserControllerTest() {
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
     * Test of create method, of class UserController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        User user = null;
        UserController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.create(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of authentication method, of class UserController.
     */
    @Test
    public void testAuthentication() {
        System.out.println("authentication");
        User user = null;
        UserController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.authentication(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findUserByToken method, of class UserController.
     */
    @Test
    public void testFindUserByToken() {
        System.out.println("findUserByToken");
        User token = null;
        UserController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.findUserByToken(token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adminCreation method, of class UserController.
     */
    @Test
    public void testAdminCreation() {
        System.out.println("adminCreation");
        User user = null;
        UserController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.adminCreation(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class UserController.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        User user = null;
        UserController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.changePassword(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class UserController.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        String userId = "";
        UserController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.read(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of all method, of class UserController.
     */
    @Test
    public void testAll() {
        System.out.println("all");
        UserController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.all();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarDatosUser method, of class UserController.
     */
    @Test
    public void testActualizarDatosUser() {
        System.out.println("actualizarDatosUser");
        User user = null;
        UserController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.actualizarDatosUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
