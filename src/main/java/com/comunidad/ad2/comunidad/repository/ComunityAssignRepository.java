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
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jesfrin
 */
public interface ComunityAssignRepository extends JpaRepository<ComunityAssign, ComunityAssignKey> {

    //Devuelve todas las comunidades creadas de un usuario
    @Query("SELECT comunity from ComunityAssign comunity where comunity.user.registroAcademico=?1 AND comunity.tipo='ADMINISTRADOR'")
    public Iterable<ComunityAssign> findComunityTypeAdminitrationByRegistroAcademico(String registroAcademico);

    /**
     * Devuelve una comunidad, y el usuario que la creo
     * @param idComunidad
     * @return 
     */ 
    @Query("SELECT comunity from ComunityAssign comunity where comunity.comunity.id=?1 AND comunity.tipo='ADMINISTRADOR'")
    public Optional<ComunityAssign> findComunityOwnerByIdComunity(int idComunidad);

    /**
     * Se busca una solicitud de union a comunidad, en base a IDComunidad,RegistroAcademico y que sea Miembro
     * @param idComunidad
     * @param registroAcademico
     * @return 
     */ 
    @Query("SELECT comunity from ComunityAssign comunity where comunity.comunity.id=?1 AND comunity.user.registroAcademico=?2 AND comunity.tipo='MIEMBRO'")
    public Optional<ComunityAssign> findByIdComunityMiembro(int idComunidad, String registroAcademico);

    @Query("SELECT comunity from ComunityAssign comunity where comunity.comunity.id=?1 AND comunity.tipo='ADMINISTRADOR'")
    public Optional<ComunityAssign> findByIdComunity(int idComunidad);
    
    @Query("SELECT comunity from ComunityAssign comunity where comunity.comunity.id=?1 AND comunity.user.registroAcademico LIKE %?2% AND comunity.estado='ESPERA' AND comunity.tipo='MIEMBRO'")
    public Iterable<ComunityAssign> findUserRequest(int idComunidad, String carnet);

    @Query("SELECT DISTINCT comunity.user from ComunityAssign comunity where comunity.comunity.id=?1")
    public Iterable<User> getAllUsersInCommunity(int idComunidad);

}
/*
//INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',4,999999999);
//INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',4,888888888);

INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',5,999999999);
INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',5,888888888);
INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',4,999999999);
INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',4,888888888);
*/