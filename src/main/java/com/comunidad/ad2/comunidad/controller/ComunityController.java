/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.service.ComunityService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/creationComunity")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> create(@RequestBody Comunity comunity) {
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("Descripcion:" + comunity.getDescripcion());
        System.out.println("Nombre:" + comunity.getNombre());
        System.out.println("Usuario:" + comunity.getUser().getRegistroAcademico());
        System.out.println("Curso:" + comunity.getCourse().getCodigoDeCurso());
        System.out.println("\n\n\n\n\n\n\n");

        return ResponseEntity.status(HttpStatus.CREATED).body(this.comunityService.save(comunity));
    }

    @PostMapping("/api/users/pruebaImagen")
    public ResponseEntity<?> prueba(@RequestBody MultipartFile file) {
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
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return ResponseEntity.ok(HttpStatus.ACCEPTED);//Si se manda un texto va a tirar error de HttpErrorResponse
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE RECIBIO LA IMAGEN");
    }

    /*        @PostMapping("/api/users/pruebaImagen")
    public ResponseEntity<?> prueba(@RequestParam("file") String  file) {
                System.out.println("\n\n\n\n\n\n\n");
                //System.out.println(file.getResource());
                //System.out.println(file.getOriginalFilename());
                //System.out.println(file.getResource());
                System.out.println("\n\n\n\n\n\n\n");
        
        return ResponseEntity.ok(file);

    }*/
 /*   @PostMapping("/prueba/imagen")
    public ResponseEntity<?> prueba(@RequestBody Comunity comunity, @RequestParam("file") String nombreImagen) {
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("Descripcion:" + comunity.getDescripcion());
        System.out.println("Nombre:" + comunity.getNombre());
        System.out.println("Usuario:" + comunity.getUser().getRegistroAcademico());
        System.out.println("Curso:" + comunity.getCourse().getCodigoDeCurso());
        System.out.println("Imagen:" + nombreImagen);
        System.out.println("\n\n\n\n\n\n\n");
        return ResponseEntity.ok(nombreImagen);

    }*/
}
