package com.comunidad.ad2.comunidad.controllImage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author fabricio
 */
public class CreadorDeDirectoriosProfile implements CreadorDeDirectoriosInterface {

    public static final String PROFILE_IMAGES = "/Profile";
    
    @Override
    public boolean createDirectory() {
        String pathParaGuardarImagen;
        File directorio;
        pathParaGuardarImagen = DIRECOTRIO_POR_DEFECTO + USER_IMAGES_DIRECTORY + PROFILE_IMAGES;
        directorio = new File(pathParaGuardarImagen);
        return directorio.mkdirs();
    }

    @Override
    public Path getPathOfImage(String nombreDeLaImagen) {
        String rutaCompleta=DIRECOTRIO_POR_DEFECTO + USER_IMAGES_DIRECTORY + PROFILE_IMAGES + "/" + nombreDeLaImagen;
        return Paths.get(rutaCompleta);
    }    
    
}
