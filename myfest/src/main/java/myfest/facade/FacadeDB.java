package myfest.facade;

import java.util.List;

import Objects.DBObject;
import Objects.GUISearchGeneral;
import Objects.GUISearchSpecific;
import myfest.dao.ArtistsDAO;
import myfest.dao.ArtistsGenresDAO;
import myfest.dao.MusicalGenresDAO;
import myfest.models.Musicalgenres;
import myfest.models.Artists;
import myfest.models.Artistsgenres;

public class FacadeDB {
	private MusicalGenresDAO musicalGenresDAO;
	private ArtistsGenresDAO artistsGenresDAO;
	private ArtistsDAO       artistsDAO;
	
	public FacadeDB(){
		musicalGenresDAO = new MusicalGenresDAO();
		artistsGenresDAO = new ArtistsGenresDAO();
		artistsDAO       = new ArtistsDAO();
	}
		
	public List<String> getSearchSpecific(GUISearchSpecific guiObject){
		return artistsDAO.getArtistData(guiObject);
	}
	
	// country search
	public List<String> getSearchCountry_Genre(String country){
		return artistsDAO.getArtistNameByCountry(country);
	}
	
	// name search
	public List<String> getSearchName(String name){
		return artistsDAO.getArtistNameByName(name);
	}

	// genre search
	public Object getIdGenre(String genreName){
		return musicalGenresDAO.getGenreId(genreName);
	}
	
	public Artists getArtistById(int id){
		return artistsDAO.getArtistsById(id);
	}
	
	public List<Artistsgenres> getArtistId(String id){
		return artistsGenresDAO.getArtistId(id);
	}
	
	// initial petitions
	public List<Musicalgenres> getGenres(){
		return musicalGenresDAO.findAll();
	}
	
	public List<String> getUbicationsArtists(){
		return artistsDAO.getUbicationsArtists();
	}
}
