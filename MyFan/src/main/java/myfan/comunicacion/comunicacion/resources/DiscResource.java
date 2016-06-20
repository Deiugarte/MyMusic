package myfan.comunicacion.comunicacion.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myfan.controller.request.AddDiscRequest;
import myfan.controller.request.AddSongRequest;
import myfan.controller.request.DeleteNewsRequest;
import myfan.domain.facade.FacadeLogic;

@Path("v1/disc")
public class DiscResource {

  @POST
  @Path("/addDisc")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addDisc(AddDiscRequest addDiscRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.addDisc(addDiscRequest); 
  }
  
  @POST
  @Path("/addSong")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addSong(AddSongRequest addSongRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.addSong(addSongRequest);
  }

  @POST
  @Path("/delete")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteNews(DeleteNewsRequest deleteNewsRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.deleteNews(deleteNewsRequest);
  }
  
  @GET
  @Path("/discography/{username}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getDiscography(@PathParam("username") int username) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.getDiscography(username);
    }
}
