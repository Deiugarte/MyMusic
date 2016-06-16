package myfest.logic;

import java.util.List;

import Objects.GUISearchGeneral;
import myfest.facade.FacadeDB;
import myfest.models.Musicalgenres;

public class GetListGenresUbications {
	private FacadeDB facadeDB;
	
	public GetListGenresUbications(){
		facadeDB = new FacadeDB();
	}	
	
	public List<String> getListUbications(){
		return facadeDB.getUbicationsArtists();
	}
	
	public List<Musicalgenres> getListGenres(){
		return facadeDB.getGenres();
	}
}

//protected final String GENRES_STATUS = "{\"GenresList\": \"%s\", \"status\":\"%s\"}";

/*	
public Response getGenresDB(){
	String response = GENRES_STATUS;
	response = String.format(response, facadeDB.getGenres(), "OK");
	return Response.status(Status.OK).entity(response).build();
}
*/