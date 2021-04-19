/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.TokenCreated;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.UserServiceImpl;
import com.comunidad.ad2.comunidad.service.enums.EstadoUsuario;
import com.comunidad.ad2.comunidad.service.enums.GeneroUsuario;
import com.comunidad.ad2.comunidad.service.enums.RolUsuario;
import java.sql.Timestamp;
import org.apache.commons.lang3.StringUtils;
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
class TokenControllerTest {
    
    @Mock
    private UserServiceImpl userService;
    
    @InjectMocks
    private TokenController tokenController;
    
    
    public TokenControllerTest() {
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
     * Test of getToken method, of class TokenController.
     */
    @Test
    void testGetToken() {
        
        User user = crearUsuario(RolUsuario.SUPER);
        when(userService.login(ArgumentMatchers.any(),ArgumentMatchers.any())).thenReturn("1111111111");
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(new TokenCreated("1111111111"));
        ResponseEntity result = this.tokenController.getToken(user);
        assertEquals(((TokenCreated)expResult.getBody()).getToken(),((TokenCreated)result.getBody()).getToken());   
    }
    
    @Test
    void testGetTokenNotExists() {
        User user = crearUsuario(RolUsuario.SUPER);
        when(userService.login(ArgumentMatchers.any(),ArgumentMatchers.any())).thenReturn(StringUtils.EMPTY);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body(new TokenCreated("1111111111"));
        ResponseEntity result = this.tokenController.getToken(user);
        assertEquals(expResult.getStatusCode(),result.getStatusCode());   
    }
    
    private User crearUsuario(RolUsuario a){
        User user = new User("201029301","aaa", "aaa", new Timestamp(400000000), GeneroUsuario.N, "aa", "aa@a.com", a, "xela", EstadoUsuario.ACTIVO);
        return user;
    }
    
}
