package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.CommunityPostState;
import com.comunidad.ad2.comunidad.service.enums.ValorationType;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author fabricio
 */
@Entity
@Table(name = "comunity_post")
public class CommunityPost implements Serializable {

    public CommunityPost() {
    }

    public CommunityPost(Comunity comunity, User user, String title, String message, String photo) {
        this.comunity = comunity;
        this.user = user;
        this.title = title;
        this.message = message;
        this.photo = photo;
    }

    @Id
    @Column(name = "id_comunity_post")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    private Comunity comunity;

    @ManyToOne
    private User user;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "message", nullable = false)
    @Type(type = "text")
    private String message;

    @Column(name = "photo", nullable = true)
    @Type(type = "text")
    private String photo;

    @Column(name = "state", nullable = true)
    @Enumerated(EnumType.STRING)
    private CommunityPostState state = CommunityPostState.ACTIVE;

    @Column(name = "rated", nullable = true)
    private int rated = 0;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at", insertable = false)
    private LocalDateTime modifiedAt;
    
    @JsonInclude
    @Transient
    private List<CommentPost> commentPost;
    
    @JsonInclude
    @Transient
    private byte[] datosFoto;
    
    //Valoracion del usuario logueado para el post
    @JsonInclude
    @Transient
    private ValorationType valoration;//Sera la valoracion del usuario actual, el que recupera los post en la sesion

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comunity getComunity() {
        return comunity;
    }

    public void setComunity(Comunity comunity) {
        this.comunity = comunity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public CommunityPostState getState() {
        return state;
    }

    public void setState(CommunityPostState state) {
        this.state = state;
    }

    public int getRated() {
        return rated;
    }

    public void setRated(int rated) {
        this.rated = rated;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public byte[] getDatosFoto() {
        return datosFoto;
    }

    public void setDatosFoto(byte[] datosFoto) {
        this.datosFoto = datosFoto;
    }

    public List<CommentPost> getCommentPost() {
        return commentPost;
    }

    public void setCommentPost(List<CommentPost> commentPost) {
        this.commentPost = commentPost;
    }


    public ValorationType getValoration() {
        return valoration;
    }

    public void setValoration(ValorationType valoration) {
        this.valoration = valoration;
    }
    
    @Override
    public String toString() {
        return "CommunityPost{" + "id=" + id + ", comunity=" + comunity + ", user="
                + user + ", title=" + title + ", message=" + message + ", photo="
                + photo + ", state=" + state + ", rated=" + rated + ", createdAt="
                + createdAt + ", modifiedAt=" + modifiedAt + ", datosFoto=" 
                + datosFoto + "valoration="+valoration+ '}';
    }

}
