/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.entity.ComunityAssignKey;
import com.comunidad.ad2.comunidad.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jesfrin
 */
public interface ComunityAssignRepository extends JpaRepository<ComunityAssign, ComunityAssignKey> {

    @Query("SELECT comunity from ComunityAssign comunity where comunity.user.registroAcademico=?1 AND comunity.tipo='ADMINISTRADOR'")
    public Iterable<ComunityAssign> findByRegistroAcademico(String registroAcademico);

    @Query("SELECT comunity from ComunityAssign comunity where comunity.comunity.id=?1")
    public Optional<ComunityAssign> findByIdComunity(int idComunidad);


}