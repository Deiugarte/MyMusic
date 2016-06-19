package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.Events;
import myfan.data.models.EventsCalifications;
import myfan.data.models.FanaticsArtists;
import myfan.data.models.Ubications;
import myfan.resources.base.AddEventRequest;
import myfan.resources.base.RecentEventsResponse;

public class EventsLogic {
	
	private FacadeDAO facadeDAO;
	private JSONFabrication jSONFabrication;
	private DateFabrication dateFabrication;
	private final String ADD_EVENT_STATUS = "{\"EventId\": \"%s\", \"status\":\"%s\"}";
	private final String ERROR_ARTIST_NOT_FOUND = "{\"Error \": \"Artist not found \"}";

	public EventsLogic() {
		facadeDAO = new FacadeDAO();
		jSONFabrication = new JSONFabrication();
		dateFabrication=new DateFabrication();
	}
	

	public Response createEvent(AddEventRequest events) {
		String response = ADD_EVENT_STATUS;
		Artists artist = facadeDAO.findArtistByUserId(events.getIdUser());
		if (artist == null) {
			return responseBuilder(ERROR_ARTIST_NOT_FOUND);
		}
		Events newEvent = new Events();
		newEvent.setArtists(artist);
		newEvent.setContent(events.getContentEvent());
		newEvent.setEventDate(dateFabrication.getDateFromString(events.getDateEvent()));
		newEvent.setCreationDate(dateFabrication.getCurrentDate());
		newEvent.setTittle(events.getTitleEvent());
		newEvent.setType(events.isConcert());
		Ubications ubications = facadeDAO.findUbicationsByName(events.getUbicationEvent());
		newEvent.setUbications(ubications);
		facadeDAO.saveEvent(newEvent);
		response = String.format(response, newEvent.getEventId(), "OK");
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

	public String getRecentEvents(int idUser, int offset) {
		List<Events> eventsList = new ArrayList<Events>();
		if (isArtist(idUser)) {
			eventsList = getEventsArtist(idUser, offset);
		}
		else{
			eventsList = getEventsFanatics(idUser, offset);
		}
		ArrayList<RecentEventsResponse> listResponse = new ArrayList<RecentEventsResponse>();
		for (int i = 0; i < eventsList.size(); i++) {
			RecentEventsResponse recentEventsResponse = new RecentEventsResponse();
			boolean isConcert=eventsList.get(i).isType();
			int idEvent=eventsList.get(i).getEventId();
			recentEventsResponse.setConcert(isConcert);
			recentEventsResponse.setContent(eventsList.get(i).getContent());
			recentEventsResponse.setCreationDate(eventsList.get(i).getCreationDate().toString());
			recentEventsResponse.setDate(eventsList.get(i).getEventDate().toString());
			recentEventsResponse.setEventId(idEvent);
			recentEventsResponse.setTitle(eventsList.get(i).getTittle());
			recentEventsResponse.setUbication(eventsList.get(i).getUbications().getName());
			recentEventsResponse.setType("event");
			if (isConcert){
				recentEventsResponse.setAverageCalificationsConcerts(calculateAverageCalificationsConcerts(idEvent));
			}
			listResponse.add(recentEventsResponse);
		}
		return jSONFabrication.jsonConverter(listResponse);
	}
	
	
	private double calculateAverageCalificationsConcerts(int idEvent) {
		List <EventsCalifications > concertCalificationsList= facadeDAO.getCalificationByConcert(idEvent);
		double sumCalifications=0;
		double averageCalifications ;
		int totalOfData=concertCalificationsList.size();
		for (int j = 0; j < totalOfData; j++) {
			sumCalifications += concertCalificationsList.get(j).getCalification();
		}
		if (totalOfData>=1){
			averageCalifications = (sumCalifications/totalOfData);
		}else{
			averageCalifications=0;
		}
		return averageCalifications;
	}

	private boolean isArtist(int idUser) {
		return facadeDAO.findArtistByUserId(idUser) != null;
	}

	private List<Events> getEventsArtist(int idUser, int offset) {
		List<Events> eventsList;
		int artistId = facadeDAO.findArtistByUserId(idUser).getArtistId();
		eventsList = facadeDAO.getEventsByArtistId(artistId, offset);
		return eventsList;
	}

	private List<Events> getEventsFanatics(int idUser,int offset) {
		int fanaticId = facadeDAO.findFanaticByUserId(idUser).getFanaticId();
		List<FanaticsArtists> fanaticsArtistsList = facadeDAO.findArtistsByFanaticId(fanaticId);
		return facadeDAO.getEventsByArtistList(fanaticsArtistsList, offset);
	}

}
