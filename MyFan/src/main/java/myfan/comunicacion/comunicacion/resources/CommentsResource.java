package myfan.comunicacion.comunicacion.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import myfan.domain.facade.FacadeLogic;

@Path("v1/comments")
public class CommentsResource {
  
  @GET
  @Path("/getEventComments/{idEvent}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getEventComments(@PathParam("idEvent") int idEvent) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.getCalificationsOfConcert(idEvent);
  }

  @GET
  @Path("/getArtistComments/{idUser}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getArtistComments(@PathParam("idUser") int idUser) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.getCalificationsOfArtist(idUser);
  }
  
  @GET
  @Path("/getDiscComments/{idDisc}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getDiscComments(@PathParam("idDisc") int idDisc) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.getCalificationsOfDisc(idDisc);
  }
}
