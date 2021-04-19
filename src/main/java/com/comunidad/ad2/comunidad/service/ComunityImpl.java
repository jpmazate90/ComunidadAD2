/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.controllImage.CreadorDeDirectoriosComunidad;
import com.comunidad.ad2.comunidad.controllImage.DibujadorDeImagenesEnDisco;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.repository.ComunityRepository;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jesfrin
 */
@Service
public class ComunityImpl implements ComunityService {

    private ComunityRepository comunityRepository;
    private CreadorDeDirectoriosComunidad creadorDeDirectoriosDeComunidad;
    private DibujadorDeImagenesEnDisco dibujadorDeImagenes;

    @Autowired
    public ComunityImpl(ComunityRepository comunityRepository) {
        this.comunityRepository = comunityRepository;
        this.creadorDeDirectoriosDeComunidad = new CreadorDeDirectoriosComunidad();
        this.dibujadorDeImagenes = new DibujadorDeImagenesEnDisco();

    }

    @Override
    public Comunity save(Comunity comunity) {
        return this.comunityRepository.save(comunity);
    }

    
    @Override
    public Comunity guardarImagen(MultipartFile file) throws IOException {
        Comunity com = new Comunity();
        this.creadorDeDirectoriosDeComunidad.createDirectory();
        Path rutaDeImagen = this.creadorDeDirectoriosDeComunidad.getPathOfImage(file.getOriginalFilename());
        this.dibujadorDeImagenes.dibujarImagen(file.getBytes(), rutaDeImagen);
        com.setFoto(rutaDeImagen.toString());
        return com;
    }

    @Override
    public Iterable<Comunity> findAll() {
        return this.comunityRepository.findAll();
    }

    @Override
    public Iterable<Comunity> getCommunitiesBySearch(String searchText) {
        return this.comunityRepository.getCommunitiesBySearch(searchText);
    }

    @Override
    public Optional<Comunity> findById(String id) {
        return this.comunityRepository.findById(Integer.parseInt(id));
    }
    
    @Override
    @Transactional
    public boolean deleteById(String idComunidad) {
        this.comunityRepository.delete(new Comunity(Integer.parseInt(idComunidad)));
        return true;
    }

}
