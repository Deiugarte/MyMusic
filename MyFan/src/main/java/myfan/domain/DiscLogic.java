package myfan.domain;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.Discs;
import myfan.data.models.Events;
import myfan.data.models.Ubications;
import myfan.resources.base.AddDiscRequest;
import myfan.resources.base.AddEventRequest;

public class DiscLogic {
	private final String ADD_DISC_STATUS = "{\"DiscId\": \"%s\", \"status\":\"%s\"}";
	private final String ERROR_ARTIST_NOT_FOUND = "{\"Error \": \"Artist not found \"}";
	private FacadeDAO facadeDAO;
	private DateFabrication dateFabrication;

	public DiscLogic() {
		facadeDAO = new FacadeDAO();
		dateFabrication=new DateFabrication();

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
	//	newDisc.setLabel(label);
		
	//	Ubications ubications = facadeDAO.findUbicationsByName(events.getUbicationEvent());
	//	newDisc.setUbications(ubications);
	//	facadeDAO.saveEvent(newDisc);
	//	response = String.format(response, newDisc.getEventId(), "OK");
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
