/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controllImage;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jesfrin
 */
public class CreadorDeDirectoriosComunidadTest {
    

    /**
     * Test of createDirectory method, of class CreadorDeDirectoriosComunidad.
     */
    @Test
    public void testCreateDirectory() {
        //Act
        System.out.println("createDirectory");
        CreadorDeDirectoriosComunidad instance = new CreadorDeDirectoriosComunidad();
        //Arrange
        boolean expResult = false;//Por que ya se creo
        boolean result = instance.createDirectory();
        //Result
        assertEquals(expResult, result);
    }

    /**
     * Test of getPathOfImage method, of class CreadorDeDirectoriosComunidad.
     */
    @Test
    public void testGetPathOfImage() {
        //Arrange
        System.out.println("getPathOfImage");
        String nombreDeLaImagen = "imagen.jpg";
        CreadorDeDirectoriosComunidad instance = new CreadorDeDirectoriosComunidad();
        String ruta=CreadorDeDirectoriosComunidad.DIRECOTRIO_POR_DEFECTO + CreadorDeDirectoriosComunidad.DIRECTORIO_DE_TODAS_LAS_IMAGENES + CreadorDeDirectoriosComunidad.IMAGNES_DE_COMUNIDADES + "/" + nombreDeLaImagen;
        //Act
        Path expResult = Paths.get(ruta);
        Path result = instance.getPathOfImage(nombreDeLaImagen);
        //Assert
        assertEquals(expResult, result);

    }
    
}
