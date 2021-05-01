/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.CommunitytPostAndUserToken;
import com.comunidad.ad2.comunidad.entity.CommentPost;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.CommentPostService;
import com.comunidad.ad2.comunidad.service.ComunityAssignService;
import com.comunidad.ad2.comunidad.service.UserService;
import com.comunidad.ad2.comunidad.service.enums.StateComment;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CommentPostControllerTest {

    private static final int ID_COMUNIDAD = 1;
    private static final int ID_COMMENT_POST = 1;
    private static final String DESCRIPCION = "DESCRIPCION";
    private static final LocalDateTime CREATED_AT = LocalDateTime.now();
    private static final StateComment stateComment = StateComment.ACTIVE;
    private static final int ID_COMM_POST = 5;
    private static final String REGISTRO_ACADEMICO = "123456789";
    private CommunityPost communityPost;
    private User user;
    private CommentPost commentPost;
    private ComunityAssign comunityAssign;
    
    @Mock
    private CommentPostService commentPostService;

    @Mock
    private ComunityAssignService comunityAssignService;

    @InjectMocks
    private CommentPostController commentPostController; // es la implementacion

    public CommentPostControllerTest() {
        this.communityPost = new CommunityPost();
        this.communityPost.setId(ID_COMM_POST);
        this.communityPost.setComunity(new Comunity(ID_COMUNIDAD));
        this.user = new User(REGISTRO_ACADEMICO);
        this.commentPost = new CommentPost(ID_COMMENT_POST, DESCRIPCION, CREATED_AT, stateComment, communityPost, user);
        this.comunityAssign = new ComunityAssign();
        this.comunityAssign.setUser(user);
    }

    /**
     * Test of create method, of class CommentPostController.
     */
    @Test
    void testCreate() {
        CommentPostController instance = Mockito.spy(this.commentPostController);

        Mockito.when(this.comunityAssignService.findCommunityUser(ID_COMM_POST, REGISTRO_ACADEMICO)).thenReturn(Optional.of(this.comunityAssign));
        Mockito.when(this.comunityAssignService.findComunityOwnerByIdComunity(ID_COMUNIDAD)).thenReturn(Optional.of(this.comunityAssign));
        Mockito.when(this.commentPostService.save(this.commentPost)).thenReturn(this.commentPost);

        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(commentPost);
        ResponseEntity result = instance.create(commentPost);
        //Arrange
        assertEquals(expResult, result);
    }
}
