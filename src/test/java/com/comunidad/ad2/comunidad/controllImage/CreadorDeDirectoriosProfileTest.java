package com.comunidad.ad2.comunidad.controllImage;

import static com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosInterface.DIRECOTRIO_POR_DEFECTO;
import static com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosInterface.USER_IMAGES_DIRECTORY;
import static com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosProfile.PROFILE_IMAGES;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fabricio
 */
public class CreadorDeDirectoriosProfileTest {
    
    private CreadorDeDirectoriosProfile creadorDeDirectoriosProfile;

    public CreadorDeDirectoriosProfileTest() {
        this.creadorDeDirectoriosProfile = new CreadorDeDirectoriosProfile();
    }
    
    @Test
    public void testCreateDirectory(){
        //Act
        CreadorDeDirectoriosProfile instance = this.creadorDeDirectoriosProfile;
        //Arrange
        boolean expResult = false;
        boolean result = instance.createDirectory();
        //Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPathOfImage(){
        //Act
        CreadorDeDirectoriosProfile instance = this.creadorDeDirectoriosProfile;
        String imagePath = "image.jpg";
        String rutaCompleta=DIRECOTRIO_POR_DEFECTO + USER_IMAGES_DIRECTORY + PROFILE_IMAGES + "/" + imagePath;
        //Arrange
        Path expResult = Paths.get(rutaCompleta);
        Path result = instance.getPathOfImage(imagePath);
        //Assert
        assertEquals(expResult, result);
    }
    
}
