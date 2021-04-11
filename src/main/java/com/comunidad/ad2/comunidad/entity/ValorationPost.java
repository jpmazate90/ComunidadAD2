/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.EstadoComunityAssign;
import com.comunidad.ad2.comunidad.service.enums.ValorationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jesfrin
 */
@Entity
@Table (name ="valoration_post")
public class ValorationPost {

    public ValorationPost() {
    }

    public ValorationPost(Integer id, CommunityPost communityPost, User user, ValorationType valoration) {
        this.id = id;
        this.communityPost = communityPost;
        this.user = user;
        this.valoration = valoration;
    }
    
    @Id
    @Column(name ="id_valoration_post")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne//Un post puede estar en varias valoraciones
    private CommunityPost communityPost;
    
    @ManyToOne//Un usuario puede estar en varias valoraciones
    private User user;
    
    @Column(name = "valoration_type", nullable = true)
    @Enumerated(EnumType.STRING)
    private ValorationType valoration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CommunityPost getCommunityPost() {
        return communityPost;
    }

    public void setCommunityPost(CommunityPost communityPost) {
        this.communityPost = communityPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ValorationType getValoration() {
        return valoration;
    }

    public void setValoration(ValorationType valoration) {
        this.valoration = valoration;
    }

 
    
}
