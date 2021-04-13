/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.CommentPost;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.repository.CommentPostRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jesfrin
 */
@Service
public class CommentPostServiceImpl implements CommentPostService {

    private CommentPostRepository commentPostRepository;

    @Autowired
    public CommentPostServiceImpl(CommentPostRepository commentPostRepository) {
        this.commentPostRepository = commentPostRepository;
    }

    @Override
    public CommentPost save(CommentPost commentPost) {
        return this.commentPostRepository.save(commentPost);
    }

    @Override
    public List<CommentPost> getCommentActiveByPost(int idCommunityPost) {
        return this.commentPostRepository.getCommentActiveByPost(idCommunityPost);
    }

    /**
     * Permite agregarle a una lista de Posts sus comentarios
     *
     * @param listCommunityPost
     */
    @Override
    public void addCommentsToPost(List<CommunityPost> listCommunityPost) {
        System.out.println("Tamano de comunidades:" + listCommunityPost.size());
        for (CommunityPost communityPost : listCommunityPost) {
            ArrayList<CommentPost> coments = (ArrayList<CommentPost>) getCommentActiveByPost(communityPost.getId());
            communityPost.setCommentPost(coments);
        } 
    }

}
