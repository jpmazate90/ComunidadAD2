/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.Course;
import com.comunidad.ad2.comunidad.repository.ComunityRepository;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class ComunityImplTest {

    public static final String NOMBRE_COMUNIDAD = "Comunidad AD2";

    @Mock
    private ComunityRepository comunityRepository;

    @InjectMocks
    private ComunityImpl comunityImpl;

    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;

    public ComunityImplTest() {
        this.recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
    }

    @Test
    public void testSave() {
        //Arrange
        Comunity comunity = crearComunidad(NOMBRE_COMUNIDAD);
        ComunityImpl spy = Mockito.spy(this.comunityImpl);

        Mockito.when(comunityRepository.save(comunity)).thenReturn(comunity);
        //act
        Comunity resultado = spy.save(comunity);
        //assert
        Assertions.assertEquals(NOMBRE_COMUNIDAD, resultado.getNombre());
        //Assertions.assertEquals(NOMBRE_COMUNIDAD,"d");

    }


    /**
     * Test of guardarImagen method, of class ComunityImpl.
     */
    @Test
    public void testGuardarImagen() throws Exception {
        //Arrange
        System.out.println("guardarImagen");
        Comunity comunity = new Comunity();
        comunity.setFoto("/foto");
        ComunityImpl spy = Mockito.spy(this.comunityImpl);
        byte[] bytesImg = this.recuperadorDeImagenesDeDisco.recuperarBytesDeImagen("src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png");
        Path rutaImagen = Paths.get("src/test/java/com/comunidad/ad2/comunidad/controllImage/image2.png");
        MockMultipartFile file = new MockMultipartFile("data", bytesImg);
        //Act
        Mockito.when(spy.guardarImagen(file)).thenReturn(comunity);
        Comunity expResult = comunity;
        Comunity result= spy.guardarImagen(file);
        //Arrange
        Assertions.assertEquals(expResult,result);
    }

    public Comunity crearComunidad(String nombreComunidad) {
        Course curso = new Course();
        return new Comunity(curso, nombreComunidad, "");
    }
}
