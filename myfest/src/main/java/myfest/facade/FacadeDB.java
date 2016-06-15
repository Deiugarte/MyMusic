package myfest.facade;

import java.util.List;

import Objects.DBObject;
import Objects.GUISearchGeneral;
import Objects.GUISearchSpecific;
import myfest.dao.ArtistsDAO;
import myfest.dao.MusicalGenresDAO;
import myfest.models.Musicalgenres;
import myfest.models.Artists;

public class FacadeDB {
	private MusicalGenresDAO musicalGenresDAO;
	private ArtistsDAO       artistsDAO;
	private DBObject dbObject;
	private String searchType;
	
	public FacadeDB(){
		musicalGenresDAO = new MusicalGenresDAO();
		artistsDAO       = new ArtistsDAO();
		dbObject         = new DBObject();
		searchType       = "";
	}
	
	public List<Artists> getArtists(){
		return artistsDAO.findAll();
	}
	
	public List<String> getSearchSpecific(GUISearchSpecific guiObject){
		return artistsDAO.getArtistData(guiObject);
	}
	
	public List<String> getSearchGeneral(GUISearchGeneral guiObject){
		searchType = guiObject.getSearchType();
		dbObject.setValue(guiObject.getValue());
		dbObject.setResultsAmount(guiObject.getResultsAmount());
		switch (searchType) {
		case "Country":
			return artistsDAO.getArtistNameByCountry(dbObject);
		case "Genre":
			return artistsDAO.getArtistNameByGenre(dbObject);
		case "Name":
			return artistsDAO.getArtistNameByCountry(dbObject);
		default:
			break;
	}
	return null;
	}
	
	
	public List<Musicalgenres> getGenres(){
		return musicalGenresDAO.findAll();
	}
	
	public List<String> getUbicationsArtists(){
		return artistsDAO.getUbicationsArtists();
	}
}
