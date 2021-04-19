/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.ComunityAssignFilters;
import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.AuxObject.MensajeRetorno;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.ComunityAssignService;
import com.comunidad.ad2.comunidad.service.ComunityService;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jesfrin
 */
@CrossOrigin
@RestController
public class ComunityAssignController {

    private ComunityAssignService comunityAssignService;
    private ComunityService comunity;

    @Autowired
    public ComunityAssignController(ComunityAssignService comunityAssignService,ComunityService comunity) {
        this.comunityAssignService = comunityAssignService;
        this.comunity=comunity;
    }

    /**
     * Permite crear una tupla que sera el intermedio entre Comunidad y Usuario
     *
     * @param comunityAssign
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/assignComunity")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<ComunityAssign> create(@RequestBody ComunityAssign comunityAssign) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comunityAssignService.save(comunityAssign));
    }

    /**
     * Permite buscar todas las comunidades que haya creado un usuario, ya sea
     * de COMUNIDAD, o SUPER
     *
     * @param user
     * @return
     * @throws IOException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findComunityByRegistroAcademico")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<Iterable<ComunityAssign>> findComunityTypeAdminitrationByRegistroAcademico(@RequestBody User user)  {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.comunityAssignService.findComunityTypeAdminitrationByRegistroAcademico(user.getRegistroAcademico()));
    }

    /**
     * Permite buscar el creador de una comunidad por ID
     *
     * @param com
     * @return
     * @throws IOException
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findComunityById")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<Object> findComunityOwnerByIdComunity(@RequestBody Comunity com)   {
        Optional<ComunityAssign> comunityFind = this.comunityAssignService.findComunityOwnerByIdComunity(com.getId());
        if (comunityFind.isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunityFind.get());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE ENCONTRO LA COMUNIDAD");
    }

    /**
     * Permite buscar un usuario y la comunidad donde es miembro, segun id de
     * comunidad
     *
     * @param comRes
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findMemberComunityById")
    public ResponseEntity<Object> findMemberComunityById(@RequestBody ComunityAssign comRes) {
        Optional<ComunityAssign> comAsig = this.comunityAssignService.findByIdComunityMiembro(comRes.getComunity().getId(), comRes.getUser().getRegistroAcademico());
        if (comAsig.isPresent()) {
            ComunityAssign comSend = comAsig.get();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(comSend);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE ENCONTRO LA SUSCRIPCION A LA COMUNIDAD");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/comunity/filtrarSolicitudesComunidades")
    public ResponseEntity<Iterable<ComunityAssign>> findComunityAsignsByIdComunity(@RequestBody ComunityAssignFilters filters)   {
        Iterable<ComunityAssign> comunityFind = this.comunityAssignService.findRequestInEspera(filters.getIdComunidad(), filters.getRegistroAcademico());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunityFind);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/updateStateComunityRequest")
    public ResponseEntity<ComunityAssign> updateStateComunityRequest(@RequestBody ComunityAssign comunityAssign) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comunityAssignService.save(comunityAssign));
    }

    @PostMapping("/api/comunity/users")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<Iterable<User>> getAllUsersInCommunity(@RequestBody OrdinaryObject params)  {
        Iterable<User> usersFind = this.comunityAssignService.getAllUsersInCommunity(params.getNumberParam());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usersFind);
    }
    /**
     * Busca los miembros Activos de una comunidad
     * @param filters
     * @return 
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/filtrarMiembrosActivosDeComunidad")
    public ResponseEntity<Iterable<ComunityAssign>> findActiveMembersOfComunity(@RequestBody ComunityAssignFilters filters){
        Iterable<ComunityAssign> comunityFind=this.comunityAssignService.findActiveMembersOfComunity(filters.getIdComunidad(), filters.getRegistroAcademico());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunityFind);
    }
    
        /**
     * Permite eliminar un usuario de una comunidad, asignando el atributo estado_solicitud a NULL
     *
     * @param comunityAssign
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/removeUserFromComunity")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<ComunityAssign> removeUserFromComunity(@RequestBody ComunityAssign comunityAssign) {
        comunityAssign.setEstado(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comunityAssignService.save(comunityAssign));
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/users/findUserComunitys")
    public ResponseEntity<Iterable<ComunityAssign>> findUserComunitys(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.comunityAssignService.findUserComunitys(user.getRegistroAcademico()));
    }

    @PostMapping("/api/comunity/deleteComunity")
    public ResponseEntity<MensajeRetorno> deleteComunity(@RequestBody ComunityAssignFilters filters) {
        Optional<Comunity> result = this.comunity.findById(filters.getIdComunidad()+"");
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MensajeRetorno("NO SE ENCONTRO LA COMUNIDAD"));
        }else{
            this.comunityAssignService.deleteAllAssignsByComunity(filters.getIdComunidad()+"");
            this.comunity.deleteById(filters.getIdComunidad()+"");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MensajeRetorno("SE ELIMINO CORRECTAMENTE LO RELACIONADO A LA COMUNIDAD CON ID: "+filters.getIdComunidad()));
        }
        
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/comunity/deleteUserFromComunity")
    public ResponseEntity<MensajeRetorno> deleteUserFromComunity(@RequestBody ComunityAssignFilters filters) {
        Optional<ComunityAssign> result = this.comunityAssignService.findByIdComunityMiembro(filters.getIdComunidad(),filters.getRegistroAcademico());
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MensajeRetorno("NO SE ENCONTRO AL USUARIO: "+filters.getRegistroAcademico()+", EN LA COMUNIDAD CON ID:"+filters.getIdComunidad()));
        }else{
            this.comunityAssignService.deleteSpecificComunityAssignMember(filters.getIdComunidad()+"",filters.getRegistroAcademico());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MensajeRetorno("SE ELIMINO CORRECTAMENTE AL USUARIO CON REGISTRO ACADEMICO: "+filters.getRegistroAcademico()+", DE LA COMUNIDAD CON ID: "+filters.getIdComunidad()));
        }
        
    }
    
    @PostMapping("/api/comunity/assigns/find/byStateAndComunity")
    public ResponseEntity<Iterable<ComunityAssign>> findComunityAsignsByStateAndIdComunity(@RequestBody ComunityAssignFilters filters) {
        Iterable<ComunityAssign> comunityFind = this.comunityAssignService.findUsersRequestByState(
                filters.getIdComunidad(), filters.getRegistroAcademico(), filters.getStateAssign());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunityFind);
    }
}
