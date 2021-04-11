/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.ValorationPost;
import com.comunidad.ad2.comunidad.repository.ValorationPostRepository;
import com.comunidad.ad2.comunidad.service.enums.ValorationType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jesfrin
 */
@Service
public class ValorationPostServiceImpl implements ValorationPostService {

    private ValorationPostRepository valorationPostRepository;

    @Autowired
    public ValorationPostServiceImpl(ValorationPostRepository valorationPostRepository) {
        this.valorationPostRepository = valorationPostRepository;
    }

    @Override
    public ValorationPost save(ValorationPost valorationPost) {
        return this.valorationPostRepository.save(valorationPost);
    }

    /**
     * Obtiene la valoracion de un usuario
     *
     * @param registroAcdemico
     * @param idComunityPost
     * @return
     */
    @Override
    public Optional<ValorationPost> getValorationPostOfUser(String registroAcdemico, int idComunityPost) {
        return valorationPostRepository.getValorationPostOfUser(registroAcdemico, idComunityPost);
    }

    /**
     *Actualiza la valoracion de un usuario
     * @param registroAcademico
     * @param idComunityPost
     * @param valoration
     * @return
     */
    @Override
    public int updateValorationPost(String registroAcademico, int idComunityPost, ValorationType valoration) {
        return this.valorationPostRepository.updateValorationPost(registroAcademico, idComunityPost, valoration);
    }

    /**
     * Anade la valoracion a la comunidad del usuario que se especifica con el
     * registro academico
     *
     * @param listaComunityPost
     * @param registroAcademico
     * @return
     */
    @Override
    public Iterable<CommunityPost> addValoration(List<CommunityPost> listaComunityPost, String registroAcademico) {
        for (CommunityPost communityPost : listaComunityPost) {
            Optional<ValorationPost> valoration = getValorationPostOfUser(registroAcademico, communityPost.getId());
            if (valoration.isPresent()) {
                communityPost.setValoration(valoration.get().getValoration());
            }
        }
        return listaComunityPost;
    }

}
