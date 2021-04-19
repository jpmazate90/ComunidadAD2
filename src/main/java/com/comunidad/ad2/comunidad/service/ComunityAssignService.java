/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.entity.User;
import java.util.Optional;

/**
 *
 * @author jesfrin
 */
public interface ComunityAssignService {

    public boolean deleteAllAssignsByComunity(String idComunidad);
    
    public boolean deleteSpecificComunityAssignMember(String idComunidad, String registroAcademico);
    
    public ComunityAssign save(ComunityAssign comunityAssign);

    public Iterable<ComunityAssign> findComunityTypeAdminitrationByRegistroAcademico(String registroAcademico);

    public Optional<ComunityAssign> findComunityOwnerByIdComunity(int idComunidad);

    /**
     *
     * @param idComunidad es id comunidad
     * *@param registroAcademico es el registro academico
     * @param registroAcademico
     * @return iterable data
     *
     */
    public Iterable<ComunityAssign> findRequestInEspera(Integer idComunidad, String registroAcademico);

    public ComunityAssign updateStateComunityRequest(ComunityAssign comunityAssign);

    public Optional<ComunityAssign> findByIdComunityMiembro(int idComunidad, String registroAcademico);

    public Iterable<ComunityAssign> findActiveMembersOfComunity(int idComunidad, String carnet);

    public Iterable<User> getAllUsersInCommunity(int idComunidad);
    
     public Iterable<ComunityAssign> findUserComunitys(String registroAcademicoDeUsuario);
     
     public Iterable<ComunityAssign> findUsersRequestByState(Integer idComunidad, String registroAcademico, String requestState);
}
