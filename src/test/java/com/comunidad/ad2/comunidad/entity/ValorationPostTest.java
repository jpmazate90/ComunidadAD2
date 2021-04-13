/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.ValorationType;
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
public class ValorationPostTest {

    private static final int ID = 1;
    private static final ValorationType VALORATION_TYPE = ValorationType.UP;
    private static final int ID_COMUNITY_POST = 5;
    private static final String REGISTRO_ACADEMICO = "123456789";

    private static CommunityPost communityPost;
    private static User user;
    private ValorationPost valorationPost;

    public ValorationPostTest() {
        this.communityPost = new CommunityPost();
        this.communityPost.setId(ID_COMUNITY_POST);
        this.user = new User();
        this.user.setRegistroAcademico(REGISTRO_ACADEMICO);
        this.valorationPost = new ValorationPost();
    }

    /**
     * Test of setValoration method, of class ValorationPost.
     */
    @Test
    public void testFullEntityTest() {
        valorationPost.setCommunityPost(communityPost);
        valorationPost.setId(ID);
        valorationPost.setUser(user);
        valorationPost.setValoration(VALORATION_TYPE);

        String expResult = "ValorationPost{" + "id=" + valorationPost.getId()
                + ", communityPost=" + valorationPost.getCommunityPost()
                + ", user=" + valorationPost.getUser()
                + ", valoration=" + valorationPost.getValoration() + '}';
        String result = this.valorationPost.toString();
        assertEquals(expResult, result);
    }

}
