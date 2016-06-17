package myfan.domain;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.resources.base.AdminGenresRequest;

public class GenresLogic {
	private final String ADD_GENRE_STATUS = "{ \"status\":\"%s\"}";
	
	public Response addNewGenres(AdminGenresRequest newGenres){
		String response = ADD_GENRE_STATUS;
		
		response = String.format(response, "OK");
		return Response.status(Status.OK).entity(response).build();
		
	}
}
