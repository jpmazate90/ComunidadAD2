package com.comunidad.ad2.comunidad.entity;

import com.comunidad.ad2.comunidad.service.enums.CommunityPostState;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fabricio
 */
public class CommunityPostTest {

    private User user;
    private Comunity comunity;
    private CommunityPost communityPost;
    public static final Integer ID_COMMUNITY_POST = 1;
    public static final String REGISTRO_ACADEMICO="123456789";
    public static final int ID_COMUNIDAD=1;
    public static final String TITLE = "TITLE";
    public static final String MESSAGE = "MESSAGE";
    public static final String PHOTO = "PHOTO";
    public static final CommunityPostState STATE = CommunityPostState.ACTIVE;
    public static final int RATED = 10;
    public static final LocalDateTime CREATED_AT= LocalDateTime.now();
    public static final LocalDateTime MODIFIED_AT= LocalDateTime.now();
    public static final byte[] DATOS_FOTO = "DATOS_FOTO".getBytes();

    public CommunityPostTest() {
        this.comunity = new Comunity(ID_COMUNIDAD);
        this.user = new User(REGISTRO_ACADEMICO);
        this.communityPost = new CommunityPost();
    }
    
    @Test
    public void testFullEntityTest(){
        //Act
        this.communityPost.setId(ID_COMMUNITY_POST);
        this.communityPost.setUser(this.user);
        this.communityPost.setComunity(this.comunity);
        this.communityPost.setTitle(TITLE);
        this.communityPost.setMessage(MESSAGE);
        this.communityPost.setPhoto(PHOTO);
        this.communityPost.setState(STATE);
        this.communityPost.setRated(RATED);
        this.communityPost.setCreatedAt(CREATED_AT);
        this.communityPost.setModifiedAt(MODIFIED_AT);
        this.communityPost.setDatosFoto(DATOS_FOTO);
        CommunityPost instance = this.communityPost;
        //Arrange
        String expResult = "CommunityPost{" + "id=" + instance.getId() + ", comunity=" + instance.getComunity() + ", user="
                + instance.getUser() + ", title=" + instance.getTitle() + ", message=" + instance.getMessage() + ", photo="
                + instance.getPhoto() + ", state=" + instance.getState() + ", rated=" + instance.getRated() + ", createdAt="
                + instance.getCreatedAt() + ", modifiedAt=" + instance.getModifiedAt() + ", datosFoto=" + instance.getDatosFoto() + '}';
        String result = instance.toString();
        //Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConstructorTest(){
        //Act
        CommunityPost instance = new CommunityPost(comunity, user, TITLE, MESSAGE, PHOTO);
        this.communityPost.setComunity(comunity);
        this.communityPost.setUser(user);
        this.communityPost.setTitle(TITLE);
        this.communityPost.setMessage(MESSAGE);
        this.communityPost.setPhoto(PHOTO);
        //Arrange
        String expResult = instance.toString();
        String result = this.communityPost.toString();
        //Assert
        assertEquals(expResult, result);
    }
    
}
