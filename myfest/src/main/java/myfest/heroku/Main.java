package myfest.heroku;

import java.util.List;

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
    List<Musicalgenres> genres = facade.getListGenres();
    List<String> ubications =  facade.getArtistUbication();
    
    System.out.println("Generos");
    for (int i=0; i < genres.size(); i++){
    	System.out.println(genres.get(i).getGenreName());
    }
    
    System.out.println("Ubicaciones");    
    for (int j=0; j < ubications.size(); j++){
    	System.out.println(ubications.get(j).toString());
    }
  }

}
