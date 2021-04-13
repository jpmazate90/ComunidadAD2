/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.ValorationPost;
import com.comunidad.ad2.comunidad.service.enums.ValorationType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jesfrin
 */
@Repository
public interface ValorationPostRepository extends JpaRepository<ValorationPost, Integer>{
    
    
   /**
    * Permite recuperar la valoracion de un usuario
    * @param registroAcdemico
    * @param idComunityPost
    * @return 
    */
    @Query("SELECT valoration from ValorationPost valoration where valoration.user.registroAcademico=?1 AND valoration.communityPost.id=?2")
    public Optional<ValorationPost> getValorationPostOfUser(String registroAcdemico,int idComunityPost);
    
    /**
     * Permite actualizar la valoracion de un usaurio
     * @param registroAcademico
     * @param idComunityPost
     * @param valoration
     * @return 
     */
    @Transactional
    @Modifying
    @Query("UPDATE ValorationPost v SET v.valoration=?3 WHERE v.user.registroAcademico=?1 AND v.communityPost.id=?2")
    public int updateValorationPost(String registroAcademico, int idComunityPost, ValorationType valoration);
}
