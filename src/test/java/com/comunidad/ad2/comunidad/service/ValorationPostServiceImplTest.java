/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.entity.ValorationPost;
import com.comunidad.ad2.comunidad.repository.ValorationPostRepository;
import com.comunidad.ad2.comunidad.service.enums.ValorationType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
class ValorationPostServiceImplTest {

    private static final int ID = 1;
    private static final ValorationType VALORATION_TYPE = ValorationType.UP;
    private static final int ID_COMUNITY_POST = 5;
    private static final String REGISTRO_ACADEMICO = "123456789";

    private static CommunityPost communityPost;
    private static User user;
    private ValorationPost valorationPost;

    @Mock
    private ValorationPostRepository valorationPostRepository;

    @InjectMocks
    private ValorationPostServiceImpl valorationPostServiceImpl;

    public ValorationPostServiceImplTest() {
        this.communityPost = new CommunityPost();
        this.communityPost.setId(ID_COMUNITY_POST);
        this.user = new User();
        this.user.setRegistroAcademico(REGISTRO_ACADEMICO);
        this.valorationPost = new ValorationPost(ID, communityPost, user, VALORATION_TYPE);
    }

    /**
     * Test of save method, of class ValorationPostServiceImpl.
     */
    @Test
    void testSave() {
        System.out.println("save");
        ValorationPostServiceImpl spy = Mockito.spy(this.valorationPostServiceImpl);
        Mockito.when(valorationPostRepository.save(this.valorationPost)).thenReturn(this.valorationPost);
        ValorationPost expResult = this.valorationPost;
        ValorationPost result = spy.save(valorationPost);
        assertEquals(expResult, result);
    }

    /**
     * Test of getValorationPostOfUser method, of class
     * ValorationPostServiceImpl.
     */
    @Test
    void testGetValorationPostOfUser() {
        System.out.println("getValorationPostOfUser");
        ValorationPostServiceImpl spy = Mockito.spy(this.valorationPostServiceImpl);
        Optional<ValorationPost> val = Optional.of(this.valorationPost);
        Mockito.when(valorationPostRepository.getValorationPostOfUser(REGISTRO_ACADEMICO, ID_COMUNITY_POST)).thenReturn(val);
        Optional<ValorationPost> expResult = val;
        Optional<ValorationPost> result = spy.getValorationPostOfUser(REGISTRO_ACADEMICO, ID_COMUNITY_POST);
        assertEquals(expResult, result);

    }

    /**
     * Test of updateValorationPost method, of class ValorationPostServiceImpl.
     */
    @Test
    void testUpdateValorationPost() {
        System.out.println("updateValorationPost");
        ValorationPostServiceImpl spy = Mockito.spy(this.valorationPostServiceImpl);
        Mockito.when(valorationPostRepository.updateValorationPost(REGISTRO_ACADEMICO, ID_COMUNITY_POST,VALORATION_TYPE)).thenReturn(0);
        int expResult = 0;
        int result = spy.updateValorationPost(REGISTRO_ACADEMICO, ID_COMUNITY_POST, VALORATION_TYPE);
        assertEquals(expResult, result);
    }

    /**
     * Test of addValoration method, of class ValorationPostServiceImpl.
     */
    @Test
    void testAddValoration() {
        System.out.println("addValoration");
        List<CommunityPost> listaComunityPost = new ArrayList<>();
        listaComunityPost.add(communityPost);
        ValorationPostServiceImpl spy = Mockito.spy(this.valorationPostServiceImpl);
        Mockito.when(spy.getValorationPostOfUser(REGISTRO_ACADEMICO, ID_COMUNITY_POST)).thenReturn(Optional.of(this.valorationPost));
        Iterable<CommunityPost> expResult = listaComunityPost;
        Iterable<CommunityPost> result = spy.addValoration(listaComunityPost, REGISTRO_ACADEMICO);
        assertEquals(expResult, result);
    }
}
