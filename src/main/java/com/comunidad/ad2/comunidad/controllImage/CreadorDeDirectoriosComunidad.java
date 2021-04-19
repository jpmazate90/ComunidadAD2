/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controllImage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author jesfrin
 */
public class CreadorDeDirectoriosComunidad implements CreadorDeDirectoriosInterface{

        public static final String IMAGNES_DE_COMUNIDADES = "/Comunidad";

    /**
     * Crea el directorio para imagenes de Comunidad
     * @return 
     */
    @Override
    public boolean createDirectory() {
        String pathParaGuardarImagen;
        File directorio;
        pathParaGuardarImagen = DIRECOTRIO_POR_DEFECTO + DIRECTORIO_DE_TODAS_LAS_IMAGENES + IMAGNES_DE_COMUNIDADES;
        directorio = new File(pathParaGuardarImagen);
        return directorio.mkdir();

    }
    
    /**
     * Forma el path de una Imagen de Comunidad
     * @param nombreDeLaImagen
     * @return 
     */
        @Override
    public Path getPathOfImage(String nombreDeLaImagen) {
        String rutaCompleta=DIRECOTRIO_POR_DEFECTO + DIRECTORIO_DE_TODAS_LAS_IMAGENES + IMAGNES_DE_COMUNIDADES + "/" + nombreDeLaImagen;
        return Paths.get(rutaCompleta);
    }

}
