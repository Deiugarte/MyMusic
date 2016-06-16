package myfest.heroku;

import java.util.List;

import Objects.GUISearchGeneral;
import myfest.dao.ArtistsDAO;
import myfest.dao.ArtistsScoresDAO;
import myfest.dao.MusicalGenresDAO;
import myfest.dao.MusicalgenresHome;
import myfest.facade.FacadeGUI;
import myfest.models.Artists;
import myfest.models.Artistsscores;
import myfest.models.Musicalgenres;

public class Main {

  public static void main(String[] args) {
    ArtistsScoresDAO artistsScoresDAO = new ArtistsScoresDAO();
    Artistsscores artistsscores = new Artistsscores();
    artistsscores.setCommentAmount(12);
    artistsscores.setScore(12);
    artistsscores.setVoters(12);
    artistsscores.setArtistScoresId(6);
    artistsScoresDAO.save(artistsscores);
    
    FacadeGUI facade = new FacadeGUI();
    GUISearchGeneral general = new GUISearchGeneral("WaG", "3");
    GUISearchGeneral country = new GUISearchGeneral("Cartago", "10");
    GUISearchGeneral genre   = new GUISearchGeneral("Bolero", "3");
    
    List<Musicalgenres> genres = facade.getListGenres();
    List<String> ubications =  facade.getListUbication();
    List<String> namesSearched = facade.getSearchNames(general);
    List<String> countriesSearched = facade.getSearchCountries(country);
    List<String> genresSearched = facade.getSearchGenders(genre);
    
    System.out.println("Generos");
    for (int i=0; i < genres.size(); i++){
    	System.out.println(genres.get(i).getGenreName());
    }
    
    System.out.println("Ubicaciones");    
    for (int j=0; j < ubications.size(); j++){
    	System.out.println(ubications.get(j).toString());
    }
    
    System.out.println("Busqueda por nombre");
    for (int m =0; m < namesSearched.size(); m++){
    	System.out.println(namesSearched.get(m));
    }
    
    System.out.println("Busqueda por países");
    for (int c =0; c < countriesSearched.size(); c++){
    	System.out.println(countriesSearched.get(c));
    }
    
    System.out.println("Busqueda por géneros");
    for (int c =0; c < genresSearched.size(); c++){
    	System.out.println(genresSearched.get(c));
    }
    
  }

}
