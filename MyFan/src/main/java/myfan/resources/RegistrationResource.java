package myfan.resources;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("v1/register")
public class RegistrationResource {

  @POST
  @Path("/fanatic")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response insertDataInDB2(@FormDataParam("file") InputStream uploadedInputStream,
      @FormDataParam("file") FormDataContentDisposition fileDetail, 
      @FormDataParam("Data") FormDataBodyPart dataRequest) {
    // dataImporterService.importDatabase(uploadedInputStream,
    // fileDetail,databaseId);
    dataRequest.setMediaType(MediaType.APPLICATION_JSON_TYPE);
    LoginRequest loginRequest = loginRequestBody.getValueAs(LoginRequest.class);
    System.out.println(fileDetail.getFileName());
    return Response.ok().build();
  }
}
