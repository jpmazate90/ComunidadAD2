package com.comunidad.ad2.comunidad.controllImage;

import static com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosInterface.DIRECOTRIO_POR_DEFECTO;
import static com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosInterface.DIRECTORIO_DE_TODAS_LAS_IMAGENES;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author fabricio
 */
public class CreadorDeDirectoriosCommunityPost implements CreadorDeDirectoriosInterface {

    public static final String POST_IMAGES = "/Post";
    
    @Override
    public boolean createDirectory() {
        String pathParaGuardarImagen;
        File directorio;
        pathParaGuardarImagen = DIRECOTRIO_POR_DEFECTO + DIRECTORIO_DE_TODAS_LAS_IMAGENES + POST_IMAGES;
        directorio = new File(pathParaGuardarImagen);
        return directorio.mkdirs();

    }

    @Override
    public Path getPathOfImage(String nombreDeLaImagen) {
        String rutaCompleta=DIRECOTRIO_POR_DEFECTO + DIRECTORIO_DE_TODAS_LAS_IMAGENES + POST_IMAGES + "/" + nombreDeLaImagen;
        return Paths.get(rutaCompleta);
    }
    
}
