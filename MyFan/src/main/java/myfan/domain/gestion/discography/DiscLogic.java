package myfan.domain.gestion.discography;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.controller.request.AddDiscRequest;
import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.Discs;
import myfan.data.models.Genres;
import myfan.domain.gestion.utils.DateFabrication;

public class DiscLogic {
	private final String ADD_DISC_STATUS = "{\"DiscId\": \"%s\", \"status\":\"%s\"}";
	private final String ERROR_ARTIST_NOT_FOUND = "{\"Error \": \"Artist not found \"}";
	private FacadeDAO facadeDAO;
	private DateFabrication dateFabrication;

	public DiscLogic() {
		facadeDAO = new FacadeDAO();
		dateFabrication = new DateFabrication();

	}

	public Response createDisc(AddDiscRequest disc) {
		String response = ADD_DISC_STATUS;
		Artists artist = facadeDAO.findArtistByUserId(disc.getIdUser());
		if (artist == null) {
			return responseBuilder(ERROR_ARTIST_NOT_FOUND);
		}
		Discs newDisc = new Discs();
		newDisc.setArtists(artist);
		newDisc.setName(disc.getNameDisc());
		newDisc.setDescription(disc.getDescriptionDisc());
		newDisc.setReleaseYear(dateFabrication.getDateFromString(disc.getReleaseYear()));
		newDisc.setLabel(disc.getLabel());
		Genres genres = facadeDAO.findGenderByName(disc.getNameGenre());
		System.out.println(genres.getName());
		newDisc.setGenres(genres);
		facadeDAO.saveDisc(newDisc); 
		newDisc = facadeDAO.findDiscByArtistAndName(artist.getArtistId(), disc.getNameDisc());
		response = String.format(response, newDisc.getDiscId(), "OK");
		return Response.status(Status.OK).entity(response).build();
	}

	/**
	 * Determina el tipo de Response
	 * 
	 * @param response
	 * @return
	 */
	private Response responseBuilder(String response) {
		return Response.status(Status.UNAUTHORIZED).entity(response).build();
	}
	
	
}
