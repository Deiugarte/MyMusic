package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.Fanatics;
import myfan.data.models.FanaticsArtists;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.resources.base.FollowArtistRequest;
import myfan.resources.base.GenresResponse;
import myfan.resources.base.UbicationsResponse;

public class UtilsLogic {
  private FacadeDAO facadeDAO;
  private JSONFabrication jSONFabrication;
  private final String FOLLOWING_STATUS = "{\"following\": \"%s\", \"status\":\"%s\"}";

  public UtilsLogic() {
    facadeDAO = new FacadeDAO();
    jSONFabrication= new JSONFabrication();
  }
  
  public String getAllGenres(){
    List<Genres> genres = facadeDAO.findAllGenres();
    ArrayList<GenresResponse> genresResponse = new ArrayList<GenresResponse>();
    for (int i = 0; i < genres.size(); i++) {
      GenresResponse genre = new GenresResponse();
      genre.setName(genres.get(i).getName());
      genresResponse.add(genre);
    }
    return jSONFabrication.jsonConverter(genresResponse);
  }
  
  public String getAllUbications(){
	    List<Ubications> ubicationsList = facadeDAO.findAllUbications();
	    ArrayList<UbicationsResponse> ubicationResponse = new ArrayList<UbicationsResponse>();
	    for (int i = 0; i < ubicationsList.size(); i++) {
	    	UbicationsResponse ubication = new UbicationsResponse();
	    	ubication.setName(ubicationsList.get(i).getName());
	      ubicationResponse.add(ubication);
	    }
	    return jSONFabrication.jsonConverter(ubicationResponse);
	  }
  
  public Response isFollowing(FollowArtistRequest followArtistRequest){
	  String response = FOLLOWING_STATUS;
	  String existRelation="";
	  	Artists artist= facadeDAO.findArtistByUserId(followArtistRequest.getIdUserArtist());
	  	Fanatics fanatic= facadeDAO.findFanaticByUserId(followArtistRequest.getIdUserFanatic());
	    FanaticsArtists fanaticsArtists=facadeDAO.findByIdArtistAndIdFanatic(artist.getArtistId(),fanatic.getFanaticId());
	    if (fanaticsArtists!=null){
	    	existRelation="true";
	    }else {
	    	existRelation="false";
	    }
	    response = String.format(response,existRelation, "OK");
	    return Response.status(Status.OK).entity(response).build();
	  
  }


}
