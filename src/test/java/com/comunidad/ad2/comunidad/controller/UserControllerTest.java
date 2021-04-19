/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.CreacionUsuarioParaPruebas;
import com.comunidad.ad2.comunidad.AuxObject.NumeroCarnet;
import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.UserServiceImpl;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jpmazate
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

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
    void testCreateWhenUserExists() {
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.findById(ArgumentMatchers.any())).thenReturn(Optional.of(user));
        when(this.userService.save(ArgumentMatchers.any())).thenReturn(user);

        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body(userService.save(user));
        ResponseEntity result = this.userController.create(user);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());

    }

    @Test
    void testCreateWhenUserNotExists() {
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        when(this.userService.save(ArgumentMatchers.any())).thenReturn(user);

        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
        ResponseEntity result = this.userController.create(user);
        assertEquals(((User) expResult.getBody()).getRegistroAcademico(), ((User) result.getBody()).getRegistroAcademico());

    }

    /**
     * Test of authentication method, of class UserController.
     */
    @Test
    void testAuthentication() {
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.userAuthentication(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(user);

        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
        ResponseEntity result = this.userController.authentication(user);
        assertEquals(((User) expResult.getBody()).getRegistroAcademico(), ((User) result.getBody()).getRegistroAcademico());

    }

    /**
     * Test of findUserByToken method, of class UserController.
     */
    @Test
    void testFindUserByTokenWhenExists() {
        User token = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.findByTokenOwnUser(ArgumentMatchers.any())).thenReturn(Optional.of(token));

        ResponseEntity expResult = ResponseEntity.ok(Optional.of(token));
        ResponseEntity result = this.userController.findUserByToken(token);
        assertEquals(((Optional<User>) result.getBody()).get().getRegistroAcademico(), ((Optional<User>) expResult.getBody()).get().getRegistroAcademico());
    }

    @Test
    void testFindUserByTokenWhenNotExists() {
        User token = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.findByTokenOwnUser(ArgumentMatchers.any())).thenReturn(Optional.empty());

        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body("NO EXISTE EL TOKEN DE AUTENTICACION");
        ResponseEntity result = this.userController.findUserByToken(token);
        assertEquals(result.getStatusCode(), expResult.getStatusCode());
    }

    /**
     * Test of adminCreation method, of class UserController.
     */
    @Test
    void testAdminCreation() {
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.adminCreation(ArgumentMatchers.any())).thenReturn(1);
        
        
        UserController instance = null;
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(1);
        ResponseEntity result = this.userController.adminCreation(user);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of changePassword method, of class UserController.
     */
    @Test
    void testChangePassword() {
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.changePasswordUser(ArgumentMatchers.any(),ArgumentMatchers.any())).thenReturn(1);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(1);
        
        ResponseEntity result = this.userController.changePassword(user);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());   
    }

    /**
     * Test of read method, of class UserController.
     */
    @Test
    void testReadWHenExists() {
        String userId = "1";
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.findById(ArgumentMatchers.any())).thenReturn(Optional.of(user));
        ResponseEntity expResult = ResponseEntity.ok(user);
        ResponseEntity result = this.userController.read(userId);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    @Test
    void testReadWHenNotExists() {
        String userId = "1";
        when(this.userService.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        ResponseEntity expResult = ResponseEntity.notFound().build();
        ResponseEntity result = this.userController.read(userId);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }

    /**
     * Test of all method, of class UserController.
     */
    @Test
    void testAll() {
        UserController instance = null;
        when(this.userService.findAll()).thenReturn(null);
        
        ResponseEntity expResult = ResponseEntity.ok(this.userService.findAll());
        ResponseEntity result = this.userController.all();
        assertEquals(expResult.getStatusCode(), result.getStatusCode());

    }

    /**
     * Test of actualizarDatosUser method, of class UserController.
     */
    @Test
    void testActualizarDatosUserWHenExists() {
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.findById(ArgumentMatchers.any())).thenReturn(Optional.of(user));
        when(this.userService.actualizarDatosUser(ArgumentMatchers.any())).thenReturn(user);
        
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body("");
        ResponseEntity result = this.userController.actualizarDatosUser(user);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
        
    }
     @Test
     void testActualizarDatosUserWHenNotExists() {
        User user = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        when(this.userService.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body("");
        ResponseEntity result = this.userController.actualizarDatosUser(user);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
        
    }
    
    @Test
    void testGetUsersBySearch() {
        OrdinaryObject ordinaryObject = new OrdinaryObject();
        String stringParam = "stringParam";
        ordinaryObject.setStringParam(stringParam);
        ResponseEntity expResult = ResponseEntity.ok(this.userService.getUsersBySearch(stringParam));
        ResponseEntity result = this.userController.getUsersBySearch(ordinaryObject);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    
    @Test
    void testGetUsersBySearchEmptyData() {
        OrdinaryObject ordinaryObject = new OrdinaryObject();
        String stringParam = " ";
        ordinaryObject.setStringParam(stringParam);
        ResponseEntity expResult = ResponseEntity.ok(this.userService.getUsersBySearch(stringParam));
        ResponseEntity result = this.userController.getUsersBySearch(ordinaryObject);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    
    @Test
    void testByFiltering() {
        User usr = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        ResponseEntity expResult = ResponseEntity.ok(this.userService.getByFiltering(usr));
        ResponseEntity result = this.userController.getByFiltering(usr);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    
    @Test
    void testFiltrarUsuario() {
        User usr = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        ResponseEntity expResult = ResponseEntity.ok(this.userService.getByFiltering(usr));
        ResponseEntity result = this.userController.filtrarUsuarios(new NumeroCarnet(usr.getRegistroAcademico()));
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    
    @Test
    void testFindUserByIdWhenisEmpty() {
        User usr = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body("NO EXISTE EL TOKEN DE AUTENTICACION");
        when(this.userService.findById(usr.getRegistroAcademico())).thenReturn(Optional.empty());
        ResponseEntity result = this.userController.findUserById(usr);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    
    @Test
    void testFindUserByIdWhenExists() {
        User usr = CreacionUsuarioParaPruebas.crearUsuario(RolUsuario.SUPER);
        ResponseEntity expResult = ResponseEntity.ok(usr);
        when(this.userService.findById(usr.getRegistroAcademico())).thenReturn(Optional.of(usr));
        ResponseEntity result = this.userController.findUserById(usr);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }



}
