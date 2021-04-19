/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.service.ComunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Comunity> create(@RequestBody Comunity comunity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comunityService.save(comunity));
    }

    /**
     * Permite que se suba una imagen
     *
     * @param file
     * @return
     */
    @PostMapping("/api/users/uploadImageComunity")
    public ResponseEntity<Object> uploadImage(@RequestBody MultipartFile file) {
        try {
            Comunity com = this.comunityService.guardarImagen(file);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(com);//Si se crea la entidad Imagen, devolver el objeto de tipo imagen
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE RECIBIO LA IMAGEN");
        }
        // return ResponseEntity.ok(HttpStatus.ACCEPTED);//Si se manda un texto va a tirar error de HttpErrorResponse

    }

    @PostMapping("/api/communities/search")
    public ResponseEntity<Iterable<Comunity>> getCommunitiesBySearch(@RequestBody OrdinaryObject searchObject) {
        if (searchObject.getStringParam().trim().isEmpty()) {
            return ResponseEntity.ok(this.comunityService.findAll());
        }
        return ResponseEntity.ok(this.comunityService.getCommunitiesBySearch(searchObject.getStringParam().trim()));
    }

}
