/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.entity.ValorationPost;
import com.comunidad.ad2.comunidad.service.ValorationPostService;
import com.comunidad.ad2.comunidad.service.enums.ValorationType;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jesfrin
 */
@ExtendWith(MockitoExtension.class)
class ValorationPostControllerTest {

    private static final int ID = 1;
    private static final ValorationType VALORATION_TYPE = ValorationType.UP;
    private static final int ID_COMUNITY_POST = 5;
    private static final String REGISTRO_ACADEMICO = "123456789";

    private static CommunityPost communityPost;
    private static User user;
    private ValorationPost valorationPost;
    
    @Mock
    private ValorationPostService valorationPostService;

    @InjectMocks
    private ValorationPostController valorationPostController;

    public ValorationPostControllerTest() {
        this.communityPost = new CommunityPost();
        this.communityPost.setId(ID_COMUNITY_POST);
        this.user = new User();
        this.user.setRegistroAcademico(REGISTRO_ACADEMICO);
        this.valorationPost = new ValorationPost(ID, communityPost, user, VALORATION_TYPE);
    }

    /**
     * Test of create method, of class ValorationPostController.
     */
    @Test
    void testCreate() {
        System.out.println("create");
        ValorationPostController spy = Mockito.spy(this.valorationPostController);
        Mockito.when(this.valorationPostService.save(valorationPost)).thenReturn(valorationPost);
        ResponseEntity<ValorationPost> expResult = ResponseEntity.status(HttpStatus.CREATED).body(this.valorationPostService.save(valorationPost));
        ResponseEntity<ValorationPost> result = spy.create(valorationPost);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateValoration method, of class ValorationPostController.
     */
    @Test
    void testUpdateValoration() {
        System.out.println("updateValoration");
        ValorationPostController spy = Mockito.spy(this.valorationPostController);
        Mockito.when(this.valorationPostService.updateValorationPost(REGISTRO_ACADEMICO,ID_COMUNITY_POST,VALORATION_TYPE)).thenReturn(0);

        ResponseEntity<ValorationPost> expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(valorationPost);
        ResponseEntity<ValorationPost> result = spy.updateValoration(valorationPost);
        assertEquals(expResult, result);

    }
}
