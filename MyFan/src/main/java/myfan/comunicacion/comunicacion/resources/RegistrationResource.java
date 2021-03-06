package myfan.comunicacion.comunicacion.resources;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import myfan.controller.request.RegisterNewArtistRequest;
import myfan.controller.request.RegisterNewFanaticRequest;
import myfan.domain.facade.FacadeLogic;



@Path("v1/register")
public class RegistrationResource {

  @POST
  @Path("/fanatic")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response registerFanatic(@FormDataParam("file") InputStream uploadedInputStream,
      @FormDataParam("file") FormDataContentDisposition fileDetail, 
      @FormDataParam("data") FormDataBodyPart dataRequest) {
    dataRequest.setMediaType(MediaType.APPLICATION_JSON_TYPE);
    RegisterNewFanaticRequest registerNewFanaticRequest = dataRequest.getValueAs(RegisterNewFanaticRequest.class);
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.registerNewFanatic(registerNewFanaticRequest, uploadedInputStream, fileDetail);
  }
  @POST
  @Path("/artist")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response registerArtist(@FormDataParam("file") InputStream uploadedInputStream,
      @FormDataParam("file") FormDataContentDisposition fileDetail, 
      @FormDataParam("data") FormDataBodyPart dataRequest) {
    dataRequest.setMediaType(MediaType.APPLICATION_JSON_TYPE);
    RegisterNewArtistRequest registerNewArtistRequest = dataRequest.getValueAs(RegisterNewArtistRequest.class);
    FacadeLogic facadeLogic = new FacadeLogic();
    System.out.println(fileDetail.getFileName());
    return facadeLogic.registerNewArtist(registerNewArtistRequest, uploadedInputStream, fileDetail);
  }
}
