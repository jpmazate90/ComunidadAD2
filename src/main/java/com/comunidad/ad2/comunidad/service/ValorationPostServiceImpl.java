/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.ValorationPost;
import com.comunidad.ad2.comunidad.repository.ValorationPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jesfrin
 */
@Service
public class ValorationPostServiceImpl implements ValorationPostService{
    
    private ValorationPostRepository valorationPostRepository;
    
    @Autowired
    public ValorationPostServiceImpl(ValorationPostRepository valorationPostRepository){
        this.valorationPostRepository = valorationPostRepository;
    }

    @Override
    public ValorationPost save(ValorationPost valorationPost) {
        return this.valorationPostRepository.save(valorationPost);
    }


}
