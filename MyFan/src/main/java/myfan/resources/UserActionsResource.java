package myfan.resources;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.DisableAccountRequest;
import myfan.resources.base.FollowArtistRequest;
import myfan.resources.base.UpdateProfileUserRequest;

@Path("v1/userActions")
public class UserActionsResource {

  @POST
  @Path("/disable")
  @Produces(MediaType.APPLICATION_JSON)
  public Response disableUser(DisableAccountRequest disableAccountRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.disableProfile(disableAccountRequest);
  }
  
  @POST
  @Path("/modifyFanatic")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response modifyFanatic(@FormDataParam("file") InputStream uploadedInputStream,
      @FormDataParam("file") FormDataContentDisposition fileDetail, 
      @FormDataParam("data") FormDataBodyPart dataRequest) {
    dataRequest.setMediaType(MediaType.APPLICATION_JSON_TYPE);
    UpdateProfileUserRequest modifyFanaticRequest = dataRequest.getValueAs(UpdateProfileUserRequest.class);
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.modifyDataFanatic(modifyFanaticRequest, uploadedInputStream, fileDetail);
    }
  
  @POST
  @Path("/modifyArtist")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response modifyArtist(@FormDataParam("file") InputStream uploadedInputStream,
      @FormDataParam("file") FormDataContentDisposition fileDetail, 
      @FormDataParam("data") FormDataBodyPart dataRequest) {
    dataRequest.setMediaType(MediaType.APPLICATION_JSON_TYPE);
    UpdateProfileUserRequest updateProfileUserRequest = dataRequest.getValueAs(UpdateProfileUserRequest.class);
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.modifyDataArtist(updateProfileUserRequest, uploadedInputStream, fileDetail);
  }
  
  @POST
  @Path("/followArtist")
  @Produces(MediaType.APPLICATION_JSON)
  public Response followArtist(FollowArtistRequest followArtistRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.followArtist(followArtistRequest);    
  }
  
  
  

}
