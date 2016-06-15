package myfest.logic;

import java.util.List;

//import javax.ws.rs.core.Response.Status;
//import javax.ws.rs.core.Response;

import myfest.facade.FacadeDB;
import myfest.models.Musicalgenres;

public class ListGenres {
	private FacadeDB facadeDB;
//	protected final String GENRES_STATUS = "{\"GenresList\": \"%s\", \"status\":\"%s\"}";
	
	public ListGenres(){
		facadeDB = new FacadeDB();
	}
	
	public List<Musicalgenres> getListGenres(){
		return facadeDB.getGenres();
	}

	
/*	
	public Response getGenresDB(){
		String response = GENRES_STATUS;
		response = String.format(response, facadeDB.getGenres(), "OK");
		return Response.status(Status.OK).entity(response).build();
	}
*/
	
}
