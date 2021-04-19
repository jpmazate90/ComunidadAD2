/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.StateComment;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author jesfrin
 */
@Entity
@Table(name = "comment_post")
public class CommentPost implements Serializable{

    public CommentPost() {

    }

    public CommentPost(int id, String descripcion, LocalDateTime createdAt, StateComment stateComment, CommunityPost comunityPost, User user) {
        this.id = id;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
        this.stateComment = stateComment;
        this.comunityPost = comunityPost;
        this.user = user;
    }

    public CommentPost(int id, String descripcion, LocalDateTime createdAt, User user) {
        this.id = id;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
        this.user = user;
    }

    
    


    @Id
    @Column(name = "id_comment_post")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "comentario", length = 150)
    private String descripcion;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private StateComment stateComment;

    //Claves foraneas
    @ManyToOne
    private CommunityPost comunityPost;

    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CommunityPost getComunityPost() {
        return comunityPost;
    }

    public void setComunityPost(CommunityPost comunityPost) {
        this.comunityPost = comunityPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StateComment getStateComment() {
        return stateComment;
    }

    public void setStateComment(StateComment stateComment) {
        this.stateComment = stateComment;
    }

    @Override
    public String toString() {
        return "CommentPost{" + "id=" + id 
                + ", descripcion=" + descripcion 
                + ", createdAt=" + createdAt
                + ", stateComment=" + stateComment
                + ", comunityPost=" + comunityPost 
                + ", user=" + user + '}';
    }

   
}
