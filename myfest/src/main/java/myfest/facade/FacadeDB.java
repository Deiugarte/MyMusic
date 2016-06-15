package myfest.facade;

import java.util.List;

import myfest.dao.ArtistsDAO;
import myfest.dao.MusicalGenresDAO;
import myfest.models.Musicalgenres;
import myfest.models.Artists;

public class FacadeDB {
	private MusicalGenresDAO musicalGenresDAO;
	private ArtistsDAO       artistsDAO;
	
	public FacadeDB(){
		musicalGenresDAO = new MusicalGenresDAO();
		artistsDAO       = new ArtistsDAO();
	}
	
	public List<Artists> getArtists(){
		return artistsDAO.findAll();
	}
	
	
	public List<Musicalgenres> getGenres(){
		return musicalGenresDAO.findAll();
	}
	
	public List<String> getUbicationsArtists(){
		return artistsDAO.getUbicationsArtists();
	}
}
