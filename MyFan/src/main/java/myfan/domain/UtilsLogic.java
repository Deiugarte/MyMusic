package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Genres;
import myfan.resources.base.GenresResponse;

public class UtilsLogic {
  private FacadeDAO facadeDAO;

  public UtilsLogic() {
    facadeDAO = new FacadeDAO();
  }
  
  public String getAllGenres(){
    List<Genres> genres = facadeDAO.findAllGenres();
    ArrayList<GenresResponse> genresResponse = new ArrayList<GenresResponse>();
    for (int i = 0; i < genres.size(); i++) {
      GenresResponse genre = new GenresResponse();
      genre.setName(genres.get(i).getName());
      genresResponse.add(genre);
    }
    return jsonConverter(genresResponse);
  }
  
  
  public String jsonConverter(Object source) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonInString= "{}";
    try {
      jsonInString = mapper.writeValueAsString(source);
      jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(source);

    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    } 
    return jsonInString;
  }

}
