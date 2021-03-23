/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controllImage;

import java.nio.file.Path;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author jesfrin
 */
public interface CreadorDeDirectoriosInterface {

    public static final String DIRECOTRIO_POR_DEFECTO = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
    public static final String DIRECTORIO_DE_TODAS_LAS_IMAGENES = "/imagenesDeComunidad";

    public boolean createDirectory();
    
    public Path getPathOfImage(String nombreDeLaImagen);
    
    
}
