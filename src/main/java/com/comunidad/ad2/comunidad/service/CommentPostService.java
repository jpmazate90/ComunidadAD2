/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.CommentPost;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import java.util.List;

/**
 *
 * @author jesfrin
 */
public interface CommentPostService {

    public CommentPost save(CommentPost commentPost);

    public List<CommentPost> getCommentActiveByPost(int idCommunityPost);

    //Agregar comentarios activos a Post
    public void addCommentsToPost(List<CommunityPost> listCommunityPost);
}
