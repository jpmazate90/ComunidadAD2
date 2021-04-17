/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.CommentPost;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.repository.CommentPostRepository;
import com.comunidad.ad2.comunidad.service.enums.StateComment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
public class CommentPostServiceImplTest {

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
    private CommentPostRepository commentPostRepository;

    @InjectMocks
    private CommentPostServiceImpl commentPostServiceImpl;

    public CommentPostServiceImplTest() {
        this.communityPost = new CommunityPost();
        this.communityPost.setId(ID_COMM_POST);
        this.user = new User(REGISTRO_ACADEMICO);
        this.commentPost = new CommentPost(ID, DESCRIPCION, CREATED_AT, stateComment, communityPost, user);
    }

    /**
     * Test of save method, of class CommentPostServiceImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        CommentPost commentPost = this.commentPost;
        CommentPostServiceImpl spy = Mockito.spy(this.commentPostServiceImpl);
        Mockito.when(this.commentPostRepository.save(commentPost)).thenReturn(commentPost);
        CommentPost expResult = this.commentPost;
        CommentPost result = spy.save(commentPost);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCommentActiveByPost method, of class CommentPostServiceImpl.
     */
    @Test
    public void testGetCommentActiveByPost() {
        System.out.println("getCommentActiveByPost");
        int idCommunityPost = ID_COMM_POST;
        CommentPostServiceImpl spy = Mockito.spy(this.commentPostServiceImpl);
        List<CommentPost> lista = new ArrayList<>();
        lista.add(commentPost);
        Mockito.when(this.commentPostRepository.getCommentActiveByPost(idCommunityPost)).thenReturn(lista);
        List<CommentPost> expResult = lista;
        List<CommentPost> result = spy.getCommentActiveByPost(idCommunityPost);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCommentsToPost method, of class CommentPostServiceImpl.
     */
    @Test
    public void testAddCommentsToPost() {
        System.out.println("addCommentsToPost");
        CommentPostServiceImpl spy = Mockito.spy(this.commentPostServiceImpl);
        List<CommunityPost> listCommunityPost = new ArrayList<>();
        listCommunityPost.add(communityPost);
        List<CommentPost> listCommentPost = new ArrayList<>();
        listCommentPost.add(commentPost);
        Mockito.when(spy.getCommentActiveByPost(ID_COMM_POST)).thenReturn(listCommentPost);
        spy.addCommentsToPost(listCommunityPost);

        List<CommentPost> expResult = listCommentPost;
        List<CommentPost> result = listCommunityPost.get(0).getCommentPost();
        assertEquals(expResult, result);

    }

}
