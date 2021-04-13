/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.ValorationPost;
import com.comunidad.ad2.comunidad.service.enums.ValorationType;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jesfrin
 */
public interface ValorationPostService {

    /**
     * Guarda una valoracion del usuario
     *
     * @param valorationPost
     * @return
     */
    public ValorationPost save(ValorationPost valorationPost);

    /**
     * Recupera una valoracion del usuario
     *
     * @param registroAcdemico
     * @param idComunityPost
     * @return
     */
    public Optional<ValorationPost> getValorationPostOfUser(String registroAcdemico, int idComunityPost);

    /**
     * Actualiza una valoracion de un usuario
     * @param registroAcademico
     * @param idComunityPost
     * @param valoration
     * @return 
     */
    public int updateValorationPost(String registroAcademico, int idComunityPost, ValorationType valoration);

    /**
     * Agrega una la valoracion del usuario a cada postDeComunidad
     *
     * @param listaComunityPost
     * @param registroAcademico
     * @return
     */
    //Metodo para agregar la valoracion del usuario logueado
    public Iterable<CommunityPost> addValoration(List<CommunityPost> listaComunityPost, String registroAcademico);
}
