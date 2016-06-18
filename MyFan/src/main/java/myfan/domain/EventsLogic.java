package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Events;
import myfan.data.models.EventsCalifications;
import myfan.data.models.FanaticsArtists;
import myfan.resources.base.RecentEventsResponse;

public class EventsLogic {
	
	private FacadeDAO facadeDAO;
	private JSON json;

	public EventsLogic() {
		facadeDAO = new FacadeDAO();
		json = new JSON();
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
			recentEventsResponse.setContentEvent(eventsList.get(i).getContent());
			recentEventsResponse.setCreationDate(eventsList.get(i).getCreationDate().toString());
			recentEventsResponse.setDateEvent(eventsList.get(i).getEventDate().toString());
			recentEventsResponse.setEventId(idEvent);
			recentEventsResponse.setTitleEvent(eventsList.get(i).getTittle());
			recentEventsResponse.setUbicationEvent(eventsList.get(i).getUbications().getName());
			if (isConcert){
				recentEventsResponse.setAverageCalificationsConcerts(calculateAverageCalificationsConcerts(idEvent));
			}
			listResponse.add(recentEventsResponse);
		}
		return json.jsonConverter(listResponse);
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
			averageCalifications = (sumCalifications/(5*totalOfData))*100;
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
