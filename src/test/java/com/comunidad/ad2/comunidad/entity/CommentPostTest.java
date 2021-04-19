/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.StateComment;
import java.time.LocalDateTime;
import javassist.compiler.TokenId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jesfrin
 */
public class CommentPostTest {

    private static final int ID = 1;
    private static final String DESCRIPCION = "DESCRIPCION";
    private static final LocalDateTime CREATED_AT = LocalDateTime.now();
    private static final StateComment STATE_COMMENT = StateComment.ACTIVE;
    private static final int ID_COMM_POST = 5;
    private static final String REGISTRO_ACADEMICO = "123456789";
    private CommunityPost communityPost;
    private User user;
    private CommentPost commentPost;

    public CommentPostTest() {
        this.communityPost = new CommunityPost();
        this.communityPost.setId(ID_COMM_POST);
        this.user = new User(REGISTRO_ACADEMICO);
        this.commentPost = new CommentPost(ID, DESCRIPCION, CREATED_AT, user);
    }

    @Test
    public void testFullEntityTest(){
        commentPost.setComunityPost(communityPost);
        commentPost.setCreatedAt(CREATED_AT);
        commentPost.setDescripcion(DESCRIPCION);
        commentPost.setId(ID);
        commentPost.setStateComment(STATE_COMMENT);
        commentPost.setUser(user);
        
        String expResult= "CommentPost{" + "id=" + commentPost.getId()
                + ", descripcion=" + commentPost.getDescripcion()
                + ", createdAt=" + commentPost.getCreatedAt()
                + ", stateComment=" + commentPost.getStateComment()
                + ", comunityPost=" + commentPost.getComunityPost()
                + ", user=" + commentPost.getUser() + '}';
        
        String result = commentPost.toString();
        assertEquals(expResult, result);
        
    }
}
