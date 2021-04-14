/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.CommentPost;
import com.comunidad.ad2.comunidad.service.CommentPostService;
import com.comunidad.ad2.comunidad.service.CommentPostServiceImpl;
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

    @Autowired
    public CommentPostController(CommentPostService commentPostService) {
        this.commentPostService = commentPostService;
    }

    @PostMapping("/api/community/post/commentCreate")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<?> create(@RequestBody CommentPost commentPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.commentPostService.save(commentPost));
    }

}
