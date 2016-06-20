package myfest.controlador_mediador.comunicacion.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import myfest.dominio.facade.FacadeGUI;
import myfest.dominio.gestionarlogicamyfest.dashboard.General;

@Path("v1/resources")
public class UtilitiesResource {
  

  @GET
  @Path("/ubicationslist")
  @Produces(MediaType.APPLICATION_JSON)
  public String getUbicationsList() {
    FacadeGUI FacadeGUI = new FacadeGUI();
    return FacadeGUI.getListUbications();
    }

  @GET
  @Path("/genreslist")
  @Produces(MediaType.APPLICATION_JSON)
  public String getGenresList() {
    FacadeGUI FacadeGUI = new FacadeGUI();
    return FacadeGUI.getListGenres();
    }
  
  @POST
  @Path("/searchData")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSearchData(General searchValue){
    FacadeGUI FacadeGUI = new FacadeGUI();
    System.out.println(searchValue.getCountry()+searchValue.getGenre()+searchValue.getName());
    return FacadeGUI.getSearch(searchValue);    
  }

  @GET
  @Path("/searchArtist/{searchValue}")
  public String getArtistData(@PathParam("searchValue") int searchValue){
    FacadeGUI FacadeGUI = new FacadeGUI();
    return FacadeGUI.getSearchArtistData(searchValue);    
  }
 
  
  
  
}
