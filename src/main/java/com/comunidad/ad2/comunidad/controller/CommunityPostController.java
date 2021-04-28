package com.comunidad.ad2.comunidad.controller;

import com.comunidad.ad2.comunidad.AuxObject.FiltrosComunityPost;
import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.service.CommunityPostService;
import java.io.IOException;
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

    @Autowired
    public CommunityPostController(CommunityPostService communityPostService) {
        this.communityPostService = communityPostService;
    }
    
    /**
     * 
     * @param comunityPost
     * @return 
     */
    @PostMapping("/api/community/post/create")//Al no estar bajo /api/users no se necesita autenticacion
    public ResponseEntity<Object> create(@RequestBody CommunityPost comunityPost) {
        CommunityPost postFind = this.communityPostService.save(comunityPost);
        if(postFind != null){
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
    
}
