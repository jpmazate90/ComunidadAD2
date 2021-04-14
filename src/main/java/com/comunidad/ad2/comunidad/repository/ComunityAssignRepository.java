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
import com.comunidad.ad2.comunidad.service.enums.EstadoComunityAssign;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    @Query("SELECT DISTINCT comunity.user from ComunityAssign comunity where comunity.comunity.id=?1 AND (comunity.tipo = 'ADMINISTRADOR' OR comunity.estado = 'ACTIVO')")
    public Iterable<User> getAllUsersInCommunity(int idComunidad);
    /**
     * Devuelve todos los miembros activos de una comunidad
     * @param idComunidad
     * @param carnet
     * @return 
     */
    @Query("SELECT comunity from ComunityAssign comunity where comunity.comunity.id=?1 AND comunity.user.registroAcademico LIKE %?2% AND comunity.estado='ACTIVO' AND comunity.tipo='MIEMBRO'")
    public Iterable<ComunityAssign> findActiveMembersOfComunity(int idComunidad,String carnet);
    
    /**
     *Permite buscar las comunidades a las que un usuario ha sido aceptado 
     * @param registroAcademicoDeUsuario
     * @return 
     */
    @Query("SELECT comunity from ComunityAssign comunity where comunity.user.registroAcademico=?1 "
            + "AND ((comunity.tipo='MIEMBRO' AND comunity.estado='ACTIVO') OR comunity.tipo='ADMINISTRADOR') ")
    public Iterable<ComunityAssign> findUserComunitys(String registroAcademicoDeUsuario);

    @Modifying
    @Query(value ="DELETE from comunity_assign where comunity_id_comunity=?1" , nativeQuery = true)
    public void deleteComunityAssignsByIdComunity(int idComunidad);
    
    @Modifying
    @Query(value ="DELETE from comunity_assign where comunity_id_comunity=?1 and user_registro_academico=?2 and tipo_assign!='ADMINISTRADOR' and estado_solicitud!='DENEGADO'" , nativeQuery = true)
    public void deleteSpecificComunityAssignMember(int idComunidad, String registroAcademico);
    
    @Query("SELECT comunity from ComunityAssign comunity where comunity.comunity.id=?1 AND comunity.user.registroAcademico LIKE %?2% AND comunity.estado=?3 AND comunity.tipo='MIEMBRO'")
    public Iterable<ComunityAssign> findUserRequestByState(int idComunidad, String carnet, EstadoComunityAssign state);
    

}
/*
//INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',4,999999999);
//INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',4,888888888);

INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',5,999999999);
INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',5,888888888);
INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',4,999999999);
INSERT INTO comunity_assign VALUES('ESPERA',now(),NULL,'MIEMBRO',4,888888888);
*/