/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.service.ComunityService;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class ComunityControllerTest {

    private Comunity comunidad;
    private Course course;

    @Mock
    private ComunityService comunityService;

    @InjectMocks
    private ComunityController comunityController;

    public ComunityControllerTest() {
        this.course = new Course("001", "MATEMATICA", 0);
        this.comunidad = new Comunity(1, course, "Primera Comunidad", "Descripcion comunidad", "/direccion/foto");
    }

    /**
     * Test of create method, of class ComunityController.
     */
    @Test
    public void testCreate() {
        System.out.println("Test create");
        Comunity comunity = this.comunidad;
        ComunityController instance = Mockito.spy(this.comunityController);
        Mockito.when(comunityService.save(comunity)).thenReturn(comunity);

        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(comunityService.save(comunity));
        ResponseEntity result = instance.create(comunity);
        //Arrange
        assertEquals(expResult, result);

    }

    /**
     * Test of uploadImage method, of class ComunityController.
     */
    @Test
    public void testUploadImage() throws IOException{
        //Arrange
        System.out.println("uploadImage");
        RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
        byte[] bytesImg = recuperadorDeImagenesDeDisco.recuperarBytesDeImagen("src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png");
        MockMultipartFile file = new MockMultipartFile("Imagen", bytesImg);
        ComunityController instance = Mockito.spy(this.comunityController);
        this.comunidad.setFoto("src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png");
        Mockito.when(comunityService.guardarImagen(file)).thenReturn(this.comunidad);
        //Act
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(comunityService.guardarImagen(file));
        ResponseEntity result = instance.uploadImage(file);
        //Assert
        assertEquals(expResult, result);

    }

    
    /**
     * Test of uploadImage method, of class ComunityController.
     */
    @Test
    public void testUploadImageWithError() throws IOException{
        //Arrange
        System.out.println("uploadImageWithError");
        RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
        byte[] bytesImg = recuperadorDeImagenesDeDisco.recuperarBytesDeImagen("src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png");
        MockMultipartFile file = new MockMultipartFile("Imagen", bytesImg);
        ComunityController instance = Mockito.spy(this.comunityController);
        this.comunidad.setFoto("src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png");
        Mockito.when(comunityService.guardarImagen(null)).thenReturn(null);
        //Act
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE RECIBIO LA IMAGEN");
        ResponseEntity result = instance.uploadImage(file);
        //Assert
        assertEquals(expResult, result);

    }
}