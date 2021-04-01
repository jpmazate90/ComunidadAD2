/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import java.util.Optional;

/**
 *
 * @author jesfrin
 */
public interface ComunityAssignService {

    public boolean deleteAllAssignsByComunity(String idComunidad);
    
    public ComunityAssign save(ComunityAssign comunityAssign);

    public Iterable<ComunityAssign> findComunityTypeAdminitrationByRegistroAcademico(String registroAcademico);

    public Optional<ComunityAssign> findComunityOwnerByIdComunity(int idComunidad);

    /**
     * 
     *@param idComunidad es id comunidad 
     * *@param registroAcademico es el registro academico
     * @param registroAcademico
     * @return iterable data
     * 
     */
    public Iterable<ComunityAssign> findRequestInEspera(Integer idComunidad, String registroAcademico);
    public ComunityAssign updateStateComunityRequest(ComunityAssign comunityAssign);


    public Optional<ComunityAssign> findByIdComunityMiembro(int idComunidad,String registroAcademico);
}
