/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.AuxObject;

import com.comunidad.ad2.comunidad.entity.CommentPost;
import com.comunidad.ad2.comunidad.entity.CommunityPost;

/**
 *
 * @author jesfrin
 */
public class CommunitytPostAndUserToken {
    
    private CommunityPost communityPost;
    private String token;

    public CommunitytPostAndUserToken(CommunityPost communityPost, String token) {
        this.communityPost = communityPost;
        this.token = token;
    }

    public CommunityPost getCommunityPost() {
        return communityPost;
    }

    public void setCommunityPost(CommunityPost communityPost) {
        this.communityPost = communityPost;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

  
    
    
}
