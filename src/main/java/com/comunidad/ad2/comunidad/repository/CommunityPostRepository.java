package com.comunidad.ad2.comunidad.repository;

import com.comunidad.ad2.comunidad.entity.CommunityPost;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fabricio
 */
public interface CommunityPostRepository extends JpaRepository<CommunityPost, Integer>,JpaSpecificationExecutor<CommunityPost> {

    @Query("SELECT comunity from CommunityPost comunity where comunity.comunity.id=?1 "
            + "AND (comunity.state = 'ACTIVE' OR comunity.state = 'PRIVATE') order by comunity.createdAt desc")
    public List<CommunityPost> getAllCommunityPostByIdComunity(int idComunidad);

    /**
     * Cambia el estado a DELETED de un Post de una comunidad
     *
     * @param idComunidad
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE CommunityPost c SET c.state='DELETED' WHERE c.id=?1  ")
    public int deletedCommunityPost(int idComunityPost);

    @Query("SELECT comunity from CommunityPost comunity where comunity.id=?1 ")
    public Optional<CommunityPost> getComunityPostById(int idComunityPost);

    @Query("SELECT comunity from CommunityPost comunity where comunity.comunity.id=?1 "
            + "AND (comunity.state = 'ACTIVE' OR comunity.state = 'PRIVATE') AND ( comunity.user.nombreCompleto like %?2%)  order by comunity.createdAt desc")
    public List<CommunityPost> getAllCommunityPostByIdComunityWithFilters(int idComunidad, String usuario, String fechaInicial, String fechaFinal);

}
