package myfan.domain;

import java.util.ArrayList;
import java.util.List;
import myfan.data.facade.FacadeDAO;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.resources.base.GenresResponse;
import myfan.resources.base.UbicationsResponse;

public class UtilsLogic {
  private FacadeDAO facadeDAO;
  private JSON json;

  public UtilsLogic() {
    facadeDAO = new FacadeDAO();
    json= new JSON();
  }
  
  public String getAllGenres(){
    List<Genres> genres = facadeDAO.findAllGenres();
    ArrayList<GenresResponse> genresResponse = new ArrayList<GenresResponse>();
    for (int i = 0; i < genres.size(); i++) {
      GenresResponse genre = new GenresResponse();
      genre.setName(genres.get(i).getName());
      genresResponse.add(genre);
    }
    return json.jsonConverter(genresResponse);
  }
  
  public String getAllUbications(){
	    List<Ubications> ubicationsList = facadeDAO.findAllUbications();
	    ArrayList<UbicationsResponse> ubicationResponse = new ArrayList<UbicationsResponse>();
	    for (int i = 0; i < ubicationsList.size(); i++) {
	    	UbicationsResponse ubication = new UbicationsResponse();
	    	ubication.setName(ubicationsList.get(i).getName());
	      ubicationResponse.add(ubication);
	    }
	    return json.jsonConverter(ubicationResponse);
	  }
  


}
