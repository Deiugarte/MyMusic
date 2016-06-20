package myfan.comunicacion.comunicacion.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myfan.controller.request.AdminGenresRequest;
import myfan.controller.request.FindArtistRequest;
import myfan.controller.request.FollowArtistRequest;
import myfan.domain.facade.FacadeLogic;

@Path("v1/resources")
public class UtilitiesResource {
  
  @GET
  @Path("/artistData/{username}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getArtistData(@PathParam("username") int username) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.getPersonalInformationOfArtist(username);
    }
  
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
  
  @GET
  @Path("/followedArtits/{username}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getDiscByFanatics(@PathParam("username") int username) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.getFollowedArtist(username);
    }
  
  @POST
  @Path("/searchData")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSearchData(FindArtistRequest findArtistRequest){
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.searchArtist(findArtistRequest);
    
  }
  
  @POST
  @Path("/followStatus")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getFollowStatus(FollowArtistRequest followArtistRequest){
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.Following(followArtistRequest);    
  }
  
  @POST
  @Path("/addNewGenre")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addNewGenre(AdminGenresRequest newGenreRequest){
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.addGenre(newGenreRequest);
  }
  
}
