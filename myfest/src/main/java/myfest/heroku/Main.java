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
    // Objetos de búsqueda
    GUISearchGeneral general = new GUISearchGeneral("WaG", "3");
    GUISearchGeneral country = new GUISearchGeneral("Cartago", "10");
    GUISearchGeneral genre   = new GUISearchGeneral("Bolero", "3");
    // Busqueda inicial
    List<Musicalgenres> genres = facade.getListGenres();
    List<String> ubications =  facade.getListUbication();
    // Search
    List<Artists> namesSearched = facade.getSearchNames(general);
    List<Artists> countriesSearched = facade.getSearchCountries(country);
    List<Artists> genresSearched = facade.getSearchGenders(genre);
    
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
    	System.out.println(namesSearched.get(m).getArtistName() + " id: " + namesSearched.get(m).getArtistId());
    }
    
    System.out.println("Busqueda por países");
    for (int c =0; c < countriesSearched.size(); c++){
    	System.out.println(countriesSearched.get(c).getArtistName() + " id: " + countriesSearched.get(c).getArtistId());
    }
    
    System.out.println("Busqueda por géneros");
    for (int c =0; c < genresSearched.size(); c++){
    	System.out.println(genresSearched.get(c).getArtistName() + " id: " + genresSearched.get(c).getArtistId() );
    }
    
    List<Object> dashboard = facade.getSearchArtistData(3);
    System.out.println("Dashboard artista: " + dashboard.get(1));
    System.out.println("Cantidad de seguidores: " + dashboard.get(2));
    System.out.println("generos del artista: ");
    List<String> genresArtist = (List<String>) dashboard.get(3);
    for (int c =0; c < genresArtist.size(); c++){
    	System.out.println(genresArtist.get(c));
    }
    System.out.println("resultados del artista: ");
    List<String> artistScore = (List<String>) dashboard.get(4);
    for (int c =0; c < artistScore.size(); c++){
    	System.out.println(artistScore.get(c));
    }
    
    System.out.println("resultados del concierto: ");
    List<String> concertsScore = (List<String>) dashboard.get(5);
    for (int c =0; c < concertsScore.size(); c++){
    	System.out.println(concertsScore.get(c));
    }
    
    System.out.println("resultados de los discos: ");
    List<String> discsScore = (List<String>) dashboard.get(6);
    for (int c =0; c < discsScore.size(); c++){
    	System.out.println(discsScore.get(c));
    }
    
    //System.out.println("cantidad de menciones en twitter: " + dashboard.get(7));
    
  }
}
