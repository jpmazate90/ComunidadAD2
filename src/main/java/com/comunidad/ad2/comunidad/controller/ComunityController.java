/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.ComunityAssignService;
import com.comunidad.ad2.comunidad.service.ComunityService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jesfrin
 */
@CrossOrigin()
@RestController
public class ComunityController {

    private ComunityService comunityService;
    
    @Autowired
    public ComunityController(ComunityService comunityService) {
        this.comunityService = comunityService;     
    }

    /**
     * Permite guardar una comunidad
     *
     * @param comunity
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/creationComunity")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> create(@RequestBody Comunity comunity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comunityService.save(comunity));
    }

    /**
     * Permite que se suba una imagen
     *
     * @param file
     * @return
     */
    @PostMapping("/api/users/uploadImageComunity")
    public ResponseEntity<?> uploadImage(@RequestBody MultipartFile file) {
        Comunity comunidad = new Comunity();
        if (file != null) {
            String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            String path2 = path + "/imagenesDeComunidad";
            File directorio = new File(path2);
            directorio.mkdir();
            try {
                //Directorio es el directorio y path es la ruta
                byte[] bytesImg = file.getBytes();
                Path rutaCompleta = Paths.get(path2 + "/" + file.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                comunidad.setFoto(rutaCompleta.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            // return ResponseEntity.ok(HttpStatus.ACCEPTED);//Si se manda un texto va a tirar error de HttpErrorResponse

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunidad);//Si se crea la entidad Imagen, devolver el objeto de tipo imagen
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE RECIBIO LA IMAGEN");
    }

    /**
     * Envia una comunidad con la informacion necesaria para crear una imagen
     *
     * @param comunity
     * @return
     * @throws IOException
     */
    @PostMapping("/api/users/pruebaCargarImagen")
    public ResponseEntity<?> pruebaCargaImagen(@RequestBody Comunity comunity) throws IOException {
        Path rutaImagen = Paths.get(comunity.getFoto());//Ruta de la imagen
        byte[] imagenBytes = Files.readAllBytes(rutaImagen);
        comunity.setDatosFoto(imagenBytes);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunity);
    }

    

}
