package com.comunidad.ad2.comunidad.controller;

 import com.comunidad.ad2.comunidad.AuxObject.FiltrosComunityPost;
 
import com.comunidad.ad2.comunidad.AuxObject.CommunitytPostAndUserToken;
 import com.comunidad.ad2.comunidad.AuxObject.OrdinaryObject;
import com.comunidad.ad2.comunidad.controllImage.RecuperadorDeImagenesDeDisco;
import com.comunidad.ad2.comunidad.entity.CommunityPost;
import com.comunidad.ad2.comunidad.entity.Comunity;
import com.comunidad.ad2.comunidad.entity.ComunityAssign;
import com.comunidad.ad2.comunidad.entity.User;
import com.comunidad.ad2.comunidad.service.CommunityPostService;
import com.comunidad.ad2.comunidad.service.ComunityAssignService;
import com.comunidad.ad2.comunidad.service.UserService;
import com.comunidad.ad2.comunidad.service.enums.CommunityPostState;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

/**
 *
 * @author fabricio
 */
@ExtendWith(MockitoExtension.class)
class CommunityPostControllerTest {

    private static final String TOKEN = "ABCTOKEN";
    private static final int ID_COMUNITY_POST = 5;
    private static final int ID_COMUNIDAD = 10;
    private CommunityPost communityPost;
    private Comunity comunity;
    private User user;
    private CommunitytPostAndUserToken communitytPostAndUserToken;
    private ComunityAssign comunityAssign;

    @Mock
    private CommunityPostService communityPostService;

    @Mock
    private ComunityAssignService comunityAssignService;

    @Mock
    private UserService userService;

    @InjectMocks
    private CommunityPostController communityPostController;

    public CommunityPostControllerTest() {
        this.comunity = new Comunity(ID_COMUNIDAD);
        this.user = new User("201023214");
        this.communityPost = new CommunityPost(comunity, user, "title", "message", "photo");
        this.communityPost.setId(ID_COMUNITY_POST);
        this.communitytPostAndUserToken = new CommunitytPostAndUserToken(communityPost, TOKEN);
        this.comunityAssign = new ComunityAssign();
        this.comunityAssign.setUser(user);
    }

    private CommunityPost createCommunityPost() {
        return new CommunityPost();
    }

    private List<CommunityPost> getPostList(int sizeList) {
        List<CommunityPost> result = new LinkedList<>();
        for (int i = 0; i < sizeList; i++) {
            result.add(createCommunityPost());
        }
        return result;
    }

    @Test
    void testCreate() {
        //Arrange
        CommunityPost post = this.communityPost;
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        //Act
        Mockito.when(this.communityPostService.save(post)).thenReturn(post);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CREATED).body(this.communityPostService.save(post));
        ResponseEntity result = instance.create(post);
        //Assert
        assertEquals(expResult, result);
    }

    @Test
    void testCreateError() {
        //Arrange
        CommunityPost post = this.communityPost;
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        //Act
        Mockito.when(this.communityPostService.save(post)).thenReturn(null);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE PUDO CREAR EL POST");;
        ResponseEntity result = instance.create(post);
        //Assert
        assertEquals(expResult, result);
    }

    @Test
    void testGetAllCommunityPostByIdComunity() throws IOException {
        //Arrange
        int numParam = 10;
        String stringParam = "111111111";
        OrdinaryObject input = new OrdinaryObject();
        input.setNumberParam(numParam);
        input.setStringParam(stringParam);
        List<CommunityPost> expListPost = getPostList(3);
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        Mockito.when(this.communityPostService.getAllCommunityPostByIdComunity(input)).thenReturn(expListPost);
        //Act
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(this.communityPostService.getAllCommunityPostByIdComunity(input));
        ResponseEntity result = instance.getAllCommunityPostByIdComunity(input);
        //Assert
        assertEquals(expResult, result);
    }

    @Test
    void testUploadPostImage() throws IOException {
        //Arrange
        String photo = "src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png";
        CommunityPost post = this.communityPost;
        RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
        byte[] bytesImg = recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(photo);
        MockMultipartFile file = new MockMultipartFile("Imagen", bytesImg);
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        post.setPhoto(photo);
        Mockito.when(this.communityPostService.savePostImage(file)).thenReturn(post);
        //Act
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(this.communityPostService.savePostImage(file));
        ResponseEntity result = instance.uploadPostImage(file);
        //Assert
        assertEquals(expResult, result);
    }

    @Test
    void testUploadPostImageError() throws IOException {
        //Arrange
        String photo = "src/test/java/com/comunidad/ad2/comunidad/controllImage/image.png";
        CommunityPost post = this.communityPost;
        RecuperadorDeImagenesDeDisco recuperadorDeImagenesDeDisco = new RecuperadorDeImagenesDeDisco();
        byte[] bytesImg = recuperadorDeImagenesDeDisco.recuperarBytesDeImagen(photo);
        MockMultipartFile file = new MockMultipartFile("Imagen", bytesImg);
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        post.setPhoto(photo);
        Mockito.when(this.communityPostService.savePostImage(null)).thenReturn(null);
        //Act
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE RECIBIO LA IMAGEN");
        ResponseEntity result = instance.uploadPostImage(file);
        //Assert
        assertEquals(expResult, result);
    }
    
    
    @Test
    void testGetAllCommunityPostByIdComunityWithFilters() throws IOException {
        //Arrange
        int numParam = 10;
        String stringParam = "111111111";
        
        FiltrosComunityPost filtros = new FiltrosComunityPost(numParam, stringParam, stringParam, stringParam, stringParam, stringParam);
        List<CommunityPost> expListPost = getPostList(3);
        Mockito.when(this.communityPostService.getAllCommunityPostByIdComunityWithFilters(filtros)).thenReturn(expListPost);
        //Act
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(expListPost);
        ResponseEntity result = this.communityPostController.getAllCommunityPostByIdComunityWithFilters(filtros);
        //Assert
        assertEquals(expResult, result);
    }

    @Test
    void testDeletedCommunityPostByCommunityOwner() {
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        CommunityPost com = new CommunityPost();
        com.setState(CommunityPostState.DELETED);
        Mockito.when(this.userService.findByTokenOwnUser(TOKEN)).thenReturn(Optional.of(this.user));
        Mockito.when(this.comunityAssignService.findComunityOwnerByIdComunity(ID_COMUNIDAD)).thenReturn(Optional.of(this.comunityAssign));
        Mockito.when(this.communityPostService.deletedCommunityPost(ID_COMUNITY_POST)).thenReturn(0);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(com);
        ResponseEntity result = instance.deletedCommunityPostByCommunityOwner(this.communitytPostAndUserToken);
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    void testDeletedCommunityPostByCommunityOwnerFail() {
        CommunityPost com = new CommunityPost();
        com.setState(CommunityPostState.ACTIVE);
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        Mockito.when(this.userService.findByTokenOwnUser(TOKEN)).thenReturn(Optional.empty());
        Mockito.when(this.comunityAssignService.findComunityOwnerByIdComunity(ID_COMUNIDAD)).thenReturn(Optional.empty());
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body(com);
        ResponseEntity result = instance.deletedCommunityPostByCommunityOwner(this.communitytPostAndUserToken);
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    void testDeleteCommunityPostByUser() {
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        CommunityPost com = new CommunityPost();
        com.setState(CommunityPostState.DELETED);
        Mockito.when(this.userService.findByTokenOwnUser(TOKEN)).thenReturn(Optional.of(this.user));
        Mockito.when(this.communityPostService.getComunityPostById(ID_COMUNITY_POST)).thenReturn(Optional.of(this.communityPost));
        Mockito.when(this.comunityAssignService.findCommunityUser(ID_COMUNIDAD, user.getRegistroAcademico())).thenReturn(Optional.of(this.comunityAssign));
        Mockito.when(this.communityPostService.deletedCommunityPost(ID_COMUNITY_POST)).thenReturn(0);
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(com);
        ResponseEntity result = instance.deleteCommunityPostByUser(this.communitytPostAndUserToken);
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    void testDeleteCommunityPostByUserFail() {
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        CommunityPost com = new CommunityPost();
        com.setState(CommunityPostState.ACTIVE);
        Mockito.when(this.userService.findByTokenOwnUser(TOKEN)).thenReturn(Optional.empty());
        Mockito.when(this.communityPostService.getComunityPostById(ID_COMUNITY_POST)).thenReturn(Optional.empty());
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body(com);
        ResponseEntity result = instance.deleteCommunityPostByUser(this.communitytPostAndUserToken);
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    void testGetCommunityPost() {
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        Mockito.when(this.communityPostService.getComunityPostById(ID_COMUNITY_POST)).thenReturn(Optional.of(this.communityPost));
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.ACCEPTED).body(this.communityPost);
        ResponseEntity result = instance.getCommunityPost(this.communityPost);
        assertEquals(expResult, result);
    }

    @Test
    void testGetCommunityPostFail() {
        CommunityPostController instance = Mockito.spy(this.communityPostController);
        Mockito.when(this.communityPostService.getComunityPostById(ID_COMUNITY_POST)).thenReturn(Optional.empty());
        ResponseEntity expResult = ResponseEntity.status(HttpStatus.CONFLICT).body(new CommunityPost());
        ResponseEntity result = instance.getCommunityPost(this.communityPost);
        assertEquals(expResult.toString(), result.toString());
    }
}
