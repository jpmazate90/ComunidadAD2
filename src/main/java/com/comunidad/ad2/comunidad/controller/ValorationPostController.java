/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.ValorationPost;
import com.comunidad.ad2.comunidad.service.ValorationPostService;
import com.comunidad.ad2.comunidad.service.enums.ValorationType;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jesfrin
 */
@CrossOrigin()
@RestController
public class ValorationPostController {

    private ValorationPostService valorationPostService;

    @Autowired
    public ValorationPostController(ValorationPostService valorationPostService) {
        this.valorationPostService = valorationPostService;
    }

    /**
     * Permite crear y modificar una valoracion
     *
     * @param valorationPost
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/createValoration")
    public ResponseEntity<ValorationPost> create(@RequestBody ValorationPost valorationPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.valorationPostService.save(valorationPost));
    }

    /**
     * Permite actualizar una valoracion
     *
     * @param valorationPost
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/updateValoration")
    public ResponseEntity<ValorationPost> updateValoration(@RequestBody ValorationPost valorationPost) {
        String registroAcdemico = valorationPost.getUser().getRegistroAcademico();
        int idComunityPost = valorationPost.getCommunityPost().getId();
        ValorationType valoration = valorationPost.getValoration();

        this.valorationPostService.updateValorationPost(registroAcdemico, idComunityPost, valoration);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(valorationPost);

    }
}
