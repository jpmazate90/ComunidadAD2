/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.CommentPost;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.service.CommentPostService;
import com.comunidad.ad2.comunidad.service.ComunityAssignService;
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
public class CommentPostController {

    private CommentPostService commentPostService;
    private ComunityAssignService comunityAssignService;

    @Autowired
    public CommentPostController(CommentPostService commentPostService, ComunityAssignService comunityAssignService) {
        this.commentPostService = commentPostService;
        this.comunityAssignService = comunityAssignService;
    }

    @PostMapping("/api/community/post/commentCreate")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<Object> create(@RequestBody CommentPost commentPost) {
        int idComunidad = commentPost.getComunityPost().getComunity().getId();
        String registroAcademico = commentPost.getUser().getRegistroAcademico();
        Optional<ComunityAssign> comunityAssignOptional = this.comunityAssignService.findCommunityUser(idComunidad, registroAcademico);
        Optional<ComunityAssign> comunityAsignAdminOptional = this.comunityAssignService.findComunityOwnerByIdComunity(idComunidad);
        if (comunityAsignAdminOptional.isPresent()) {
            String userAdminRegistroAcademico = comunityAsignAdminOptional.get().getUser().getRegistroAcademico();
            if (userAdminRegistroAcademico.equalsIgnoreCase(registroAcademico) || comunityAssignOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(this.commentPostService.save(commentPost));
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("SIN_GUARDAR_COMENTARIO");
    }

}
