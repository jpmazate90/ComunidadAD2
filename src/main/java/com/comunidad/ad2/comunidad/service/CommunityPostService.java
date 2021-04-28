package com.comunidad.ad2.comunidad.service;

import com.comunidad.ad2.comunidad.AuxObject.FiltrosComunityPost;
import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fabricio
 */
public interface CommunityPostService {
    
    public CommunityPost save(CommunityPost communityPost);
    
    public Iterable<CommunityPost> getAllCommunityPostByIdComunity(OrdinaryObject ordinaryObject);
    public Iterable<CommunityPost> getAllCommunityPostByIdComunityWithFilters(FiltrosComunityPost filtros);
    
    public CommunityPost savePostImage(MultipartFile file) throws IOException;
    
}
