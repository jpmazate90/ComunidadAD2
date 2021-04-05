package com.comunidad.ad2.comunidad.controllImage;

import static com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosCommunityPost.POST_IMAGES;
import static com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosInterface.DIRECOTRIO_POR_DEFECTO;
import static com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosInterface.DIRECTORIO_DE_TODAS_LAS_IMAGENES;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fabricio
 */
public class CreadorDeDirectoriosCommunityPostTest {
    
    private CreadorDeDirectoriosCommunityPost creadorDeDirectoriosCommunityPost;

    public CreadorDeDirectoriosCommunityPostTest() {
        this.creadorDeDirectoriosCommunityPost = new CreadorDeDirectoriosCommunityPost();
    }

    @Test
    public void testCreateDirectory(){
        //Act
        CreadorDeDirectoriosCommunityPost instance = this.creadorDeDirectoriosCommunityPost;
        //Arrange
        boolean expResult = false;
        boolean result = instance.createDirectory();
        //Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPathOfImage(){
        //Act
        String imagePath = "imagen.jpg";
        String rutaCompleta=DIRECOTRIO_POR_DEFECTO + DIRECTORIO_DE_TODAS_LAS_IMAGENES + POST_IMAGES + "/" + imagePath;
        //Arrange
        Path expResult = Paths.get(rutaCompleta);
        Path result = this.creadorDeDirectoriosCommunityPost.getPathOfImage(imagePath);
        //Assert
        assertEquals(expResult, result);
        
    }
    
}
