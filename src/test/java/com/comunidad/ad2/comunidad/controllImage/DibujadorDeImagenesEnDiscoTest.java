/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controllImage;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class DibujadorDeImagenesEnDiscoTest {

    private RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco;
    
    public DibujadorDeImagenesEnDiscoTest() {
        this.recuperadorDeImagenesDeDisco=new RecuperadorDeImagenesDeDisco();
    }

    /**
     * Test of dibujarImagen method, of class DibujadorDeImagenesEnDisco.
     */
    @Test
    public void testDibujarImagen() {
        //Arrange
        System.out.println("dibujarImagen");
        byte[] bytesImg=this.recuperadorDeImagenesDeDisco.recuperarBytesDeImagen("src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png");
        Path rutaImagen = Paths.get("src/test/java/com/comunidad/ad2/comunidad/controllImage/image2.png");
        System.out.println(bytesImg);
        DibujadorDeImagenesEnDisco instance = new DibujadorDeImagenesEnDisco();
        //Act
        boolean expResult = true;
        boolean result = instance.dibujarImagen(bytesImg, rutaImagen);
        //Assert
        assertEquals(expResult, result);
    }


}
