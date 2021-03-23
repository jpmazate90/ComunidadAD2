/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.jdbc.Sql;

/**
 *
 * @author jesfrin
 */
public interface ComunityRepository extends JpaRepository<Comunity, Integer> {

    //@Query("SELECT c FROM Comunity com join com.user WHERE com.id=:id")u.registroAcademico=?1 
    //@Query("SELECT comunity from Comunity comunity where comunity.user.registroAcademico=?1")
    //public Iterable<Comunity> findByRegistroAcademico(String registroAcademico);

     
}
