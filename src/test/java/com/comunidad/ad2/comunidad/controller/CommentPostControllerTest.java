/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.CommentPost;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.CommentPostService;
import com.comunidad.ad2.comunidad.service.enums.StateComment;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
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
public class CommentPostControllerTest {

    private static final int ID = 1;
    private static final String DESCRIPCION = "DESCRIPCION";
    private static final LocalDateTime CREATED_AT = LocalDateTime.now();
    private static final StateComment stateComment = StateComment.ACTIVE;
    private static final int ID_COMM_POST = 5;
    private static final String REGISTRO_ACADEMICO = "123456789";
    private CommunityPost communityPost;
    private User user;
    private CommentPost commentPost;

    @Mock
    private CommentPostService commentPostService;

    @InjectMocks
    private CommentPostController commentPostController; // es la implementacion

    public CommentPostControllerTest() {
        this.communityPost = new CommunityPost();
        this.communityPost.setId(ID_COMM_POST);
        this.user = new User(REGISTRO_ACADEMICO);
        this.commentPost = new CommentPost(ID, DESCRIPCION, CREATED_AT, stateComment, communityPost, user);
    }

    /**
     * Test of create method, of class CommentPostController.
     */
    @Test
    public void testCreate() {
        System.out.println("Test create");
        CommentPostController instance = Mockito.spy(this.commentPostController);
        Mockito.when(this.commentPostService.save(this.commentPost)).thenReturn(this.commentPost);

        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(commentPost);
        ResponseEntity result = instance.create(commentPost);
        //Arrange
        assertEquals(expResult, result);
    }

}
