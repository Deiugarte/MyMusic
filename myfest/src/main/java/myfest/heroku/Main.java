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
import myfest.objects.request.General;
import myfest.objects.request.Specific;


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
    // Objetos de búsqueda
    General general = new General();
    general.setAmount("10");
    general.setName("W");
    general.setGenre("Salsa");
    general.setCountry("Francia");
    Specific spec   = new Specific("1");
    
    // Busqueda inicial
    String genres = facade.getListGenres();
    String ubications =  facade.getListUbications();
    // Search
    String namesSearched = facade.getSearch(general);
    // Dashboard
    String dashboard = facade.getSearchArtistData(spec);
    
    
    System.out.println("Generos con json:\n"+genres);    
    
    System.out.println("Ubicaciones con json:\n"+ubications);    
    
    System.out.println("Busqueda por filtros:\n"+namesSearched);
    
    //System.out.println("Busqueda por países:\n"+countriesSearched);
    
    //System.out.println("Busqueda por géneros:\n"+genresSearched);
    
    System.out.println("Dashboard:\n"+dashboard);
    
    //String dashboard = facade.getSearchArtistData(artistID);;
    
    //System.out.println("cantidad de menciones en twitter: " + dashboard.get(7));
    
  }
}
