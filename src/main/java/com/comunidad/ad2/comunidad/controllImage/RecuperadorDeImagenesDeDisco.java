/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controllImage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesfrin
 */
public class RecuperadorDeImagenesDeDisco {
    
    public byte[] recuperarBytesDeImagen(String foto){
        Path rutaImagen = Paths.get(foto);
        byte[] imagenBytes=null;
        try {
            imagenBytes = Files.readAllBytes(rutaImagen);
        } catch (IOException ex) {
            Logger.getLogger(RecuperadorDeImagenesDeDisco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagenBytes;
    }
}
