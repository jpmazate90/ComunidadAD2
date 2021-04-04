package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.entity.CommunityPost;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fabricio
 */
public interface CommunityPostService {
    
    public CommunityPost save(CommunityPost communityPost);
    
    public Iterable<CommunityPost> getAllCommunityPostByIdComunity(int idComunidad);
    
    public CommunityPost savePostImage(MultipartFile file) throws IOException;
    
}
