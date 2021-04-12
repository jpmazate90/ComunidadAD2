/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.CommentPost;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jesfrin
 */
public interface CommentPostRepository extends JpaRepository<CommentPost, Integer>{
    
    @Query("SELECT new CommentPost(comment.id,comment.descripcion,comment.createdAt,comment.user) FROM CommentPost comment WHERE comment.stateComment='ACTIVE' AND comment.comunityPost.id=?1")
    public List<CommentPost> getCommentActiveByPost(int idCommunityPost);
}
