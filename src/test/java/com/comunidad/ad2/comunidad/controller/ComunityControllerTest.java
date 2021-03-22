/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.service.ComunityService;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class ComunityControllerTest {
    
    @Mock
    private ComunityService comunityService;
    
    @InjectMocks
    private ComunityController comunityController;
    
    public ComunityControllerTest() {
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
     * Test of create method, of class ComunityController.
     */
    @Test
    public void testCreate() {
        Comunity comunity = crearComunidad();
        when(this.comunityService.save(comunity)).thenReturn(comunity);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(comunity);
        ResponseEntity result = this.comunityController.create(comunity);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
        
    }

    /**
     * Test of uploadImage method, of class ComunityController.
     */
    @Test
    public void testUploadImage() throws IOException {
        MultipartFile file = null;
        Comunity comunity = crearComunidad();
        when(this.comunityService.guardarImagen(ArgumentMatchers.any())).thenReturn(comunity);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(comunity);
        ResponseEntity result = this.comunityController.uploadImage(file);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    
    @Test
    public void testUploadImageWhenFailed() throws IOException {
        MultipartFile file = null;
        Comunity comunity = crearComunidad();
        when(this.comunityService.guardarImagen(ArgumentMatchers.any())).thenThrow(new IOException());
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body(comunity);
        ResponseEntity result = this.comunityController.uploadImage(file);
        assertEquals(expResult.getStatusCode(), result.getStatusCode());
    }
    
    private Comunity crearComunidad(){
        return new Comunity(1, new Course("","",2), "", "","");
    }
    
}
