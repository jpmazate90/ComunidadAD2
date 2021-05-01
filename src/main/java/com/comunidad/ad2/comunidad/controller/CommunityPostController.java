package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.CommunitytPostAndUserToken;
import com.comunidad.ad2.comunidad.AuxObject.FiltrosComunityPost;
import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.CommunityPostService;
import com.comunidad.ad2.comunidad.service.ComunityAssignService;
import com.comunidad.ad2.comunidad.service.UserService;
import com.comunidad.ad2.comunidad.service.enums.CommunityPostState;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fabricio
 */
@CrossOrigin()
@RestController
public class CommunityPostController {

    private CommunityPostService communityPostService;
    private UserService userService;
    private ComunityAssignService comunityAssignService;

    @Autowired
    public CommunityPostController(CommunityPostService communityPostService, UserService userService,
            ComunityAssignService comunityAssignService) {
        this.communityPostService = communityPostService;
        this.userService = userService;
        this.comunityAssignService = comunityAssignService;
    }

    /**
     *
     * @param comunityPost
     * @return
     */
    @PostMapping("/api/community/post/create")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<Object> create(@RequestBody CommunityPost comunityPost) {
        CommunityPost postFind = this.communityPostService.save(comunityPost);
        if (postFind != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(postFind);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE PUDO CREAR EL POST");
    }

    /**
     *
     * @param params
     * @return
     * @throws IOException
     */
    @PostMapping("/api/community/post/get/allByCommunity")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<Iterable<CommunityPost>> getAllCommunityPostByIdComunity(@RequestBody OrdinaryObject params) {
        Iterable<CommunityPost> communityPost = this.communityPostService.getAllCommunityPostByIdComunity(params);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(communityPost);
    }

    @PostMapping("/api/community/post/get/allByCommunityFilters")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<Iterable<CommunityPost>> getAllCommunityPostByIdComunityWithFilters(@RequestBody FiltrosComunityPost params) {
        Iterable<CommunityPost> communityPost = this.communityPostService.getAllCommunityPostByIdComunityWithFilters(params);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(communityPost);
    }

    @PostMapping("/api/community/post/upload/images")
    public ResponseEntity<Object> uploadPostImage(@RequestBody MultipartFile file) {
        try {
            CommunityPost post = this.communityPostService.savePostImage(file);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(post);//Si se crea la entidad Imagen, devolver el objeto de tipo imagen
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE RECIBIO LA IMAGEN");
        }
    }

    /**
     * Elimina el post de una comunidad, verificando que el usuario que lo
     * eliminara sea el creador de la comunidad
     *
     * @param communitytPostAndUserToken
     * @return
     */
    @PostMapping("/api/community/post/adminDeleteComunity")
    public ResponseEntity<CommunityPost> deletedCommunityPostByCommunityOwner(@RequestBody CommunitytPostAndUserToken communitytPostAndUserToken) {
        CommunityPost com = new CommunityPost();
        Optional<User> userOptional = userService.findByTokenOwnUser(communitytPostAndUserToken.getToken());
        int idComunidad = communitytPostAndUserToken.getCommunityPost().getComunity().getId();
        Optional<ComunityAssign> comunityAsignOptional = this.comunityAssignService.findComunityOwnerByIdComunity(idComunidad);
        //Usuario des sesion, usuario que creo la comunidad 
        if (userOptional.isPresent() && comunityAsignOptional.isPresent()) {
            User userSesion = userOptional.get();
            User userComunityOwner = comunityAsignOptional.get().getUser();
            if (userSesion.getRegistroAcademico() == userComunityOwner.getRegistroAcademico()) {
                this.communityPostService.deletedCommunityPost(communitytPostAndUserToken.getCommunityPost().getId());
                com.setState(CommunityPostState.DELETED);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(com);
            }
        }
        com.setState(CommunityPostState.ACTIVE);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(com);
    }

    /**
     * Eliminara un post de una comunidad, verificando que el usuario se el
     * creador del post, y pertenezca actualmente a la comunidad
     *
     * @param communitytPostAndUserToken
     * @return
     */
    @PostMapping("/api/community/post/userDeleteComunity")
    public ResponseEntity<CommunityPost> deleteCommunityPostByUser(@RequestBody CommunitytPostAndUserToken communitytPostAndUserToken) {
        CommunityPost com = new CommunityPost();
        int idCommunityPost = communitytPostAndUserToken.getCommunityPost().getId();
        Optional<User> userOptional = userService.findByTokenOwnUser(communitytPostAndUserToken.getToken());
        Optional<CommunityPost> communityPostOptional = this.communityPostService.getComunityPostById(idCommunityPost);
        if (userOptional.isPresent() && communityPostOptional.isPresent()) {
            User userSesion = userOptional.get();
            User userCommunityPost = communityPostOptional.get().getUser();
            if (userSesion.getRegistroAcademico() == userCommunityPost.getRegistroAcademico()) {
                int idComunidad = communityPostOptional.get().getComunity().getId();
                Optional<ComunityAssign> comunityAssignOptional = this.comunityAssignService.findCommunityUser(idComunidad, userSesion.getRegistroAcademico());
                if (comunityAssignOptional.isPresent()) {
                    this.communityPostService.deletedCommunityPost(communitytPostAndUserToken.getCommunityPost().getId());
                    com.setState(CommunityPostState.DELETED);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(com);
                }
            }
        }
        com.setState(CommunityPostState.ACTIVE);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(com);
    }

    @PostMapping("/api/community/post/getPost")
    public ResponseEntity<CommunityPost> getCommunityPost(@RequestBody CommunityPost communityPost) {
        Optional<CommunityPost> communityPostOptional = this.communityPostService.getComunityPostById(communityPost.getId());
        if (communityPostOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(communityPostOptional.get());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new CommunityPost());
    }

}
