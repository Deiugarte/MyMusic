package myfan.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import myfan.domain.facade.FacadeLogic;

@Path("v1/resources")
public class UtilitiesResource {
  
  @GET
  @Path("/genreslist")
  @Produces(MediaType.APPLICATION_JSON)
  public String getGenresList() {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.getAllGenders();
    
  }

  @GET
  @Path("/ubicationslist")
  @Produces(MediaType.APPLICATION_JSON)
  public String getUbicationsList() {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.getAllUbications();
    }

  @GET
  @Path("/userdata/{username}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getUserData(@PathParam("username") int username) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.getPersonalInformationOfFanatic(username);
    }
}
