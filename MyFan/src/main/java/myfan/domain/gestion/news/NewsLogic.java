package myfan.domain.gestion.news;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.controller.request.AddNewsRequest;
import myfan.controller.request.DeleteNewsRequest;
import myfan.controller.response.RecentNewsResponse;
import myfan.controller.response.json.JSONFabrication;
import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.FanaticsArtists;
import myfan.data.models.News;
import myfan.domain.gestion.utils.DateFabrication;

public class NewsLogic {
	private FacadeDAO facadeDAO;
	private JSONFabrication jSONFabrication;
	private DateFabrication dateFabrication;
	private final String ADD_NEWS_STATUS = "{\"NewsId\": \"%s\", \"status\":\"%s\"}";
	private final String ERROR_ARTIST_NOT_FOUND = "{\"Error \": \"Artist not found \"}";
	private final String DELETE_NEWS_STATUS = "{ \"status\":\"%s\"}";
	private final String ERROR_NEWS_NOT_FOUND = "{\"Error \": \"News not found \"}";

	public NewsLogic() {
		facadeDAO = new FacadeDAO();
		jSONFabrication = new JSONFabrication();
		dateFabrication = new DateFabrication();
	}

	public Response deleteNews(DeleteNewsRequest deleteNewsRequest) {
		String response = DELETE_NEWS_STATUS;
		News news = facadeDAO.findNewsById(deleteNewsRequest.getNewsId());
		if (news == null) {
			return responseBuilder(ERROR_NEWS_NOT_FOUND);
		}
		facadeDAO.deleteNewsById(news);
		response = String.format(response, "OK");
		return Response.status(Status.OK).entity(response).build();
	}

	public Response createNews(AddNewsRequest news) {
		String response = ADD_NEWS_STATUS;
		Artists artist = facadeDAO.findArtistByUserId(news.getIdUser());
		if (artist == null) {
			return responseBuilder(ERROR_ARTIST_NOT_FOUND);
		}
		News newNews = new News();
		newNews.setArtists(artist);
		newNews.setContent(news.getContentNews());
		newNews.setDate(dateFabrication.getDateFromString(news.getDateNews()));
		newNews.setCreationDate(dateFabrication.getCurrentDate());
		newNews.setTittle(news.getTitleNews());
		facadeDAO.saveNews(newNews);

		response = String.format(response, newNews.getNewsId(), "OK");
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

	public String getRecentNews(int idUser, int offset) {
		List<News> newsList = new ArrayList<News>();
		if (isArtist(idUser)) {
			newsList = getNewsArtist(idUser, offset);
		} else {
		  System.out.println("entre");
			newsList = getNewsFanatics(idUser, offset);
		}
		ArrayList<RecentNewsResponse> listResponse = new ArrayList<RecentNewsResponse>();
		for (int i = 0; i < newsList.size(); i++) {
			RecentNewsResponse recentNewsResponse = new RecentNewsResponse();
			recentNewsResponse.setContent(newsList.get(i).getContent());
			recentNewsResponse.setCreationDate(newsList.get(i).getCreationDate().toString());
			recentNewsResponse.setDate(newsList.get(i).getDate().toString());
			recentNewsResponse.setIdNews(newsList.get(i).getNewsId());
			recentNewsResponse.setTitle(newsList.get(i).getTittle());
			recentNewsResponse.setType("news");
			listResponse.add(recentNewsResponse);
		}
		return jSONFabrication.jsonConverter(listResponse);
	}

	private boolean isArtist(int idUser) {
		return facadeDAO.findArtistByUserId(idUser) != null;
	}

	private List<News> getNewsArtist(int idUser, int offset) {
		List<News> newsList;
		int artistId = facadeDAO.findArtistByUserId(idUser).getArtistId();
		newsList = facadeDAO.getNewsByArtistId(artistId, offset);
		return newsList;
	}

	private List<News> getNewsFanatics(int idUser, int offset) {
		int fanaticId = facadeDAO.findFanaticByUserId(idUser).getFanaticId();
		List<FanaticsArtists> fanaticsArtistsList = facadeDAO.findArtistsByFanaticId(fanaticId);
		return facadeDAO.getNewsByArtistList(fanaticsArtistsList, offset);
	}

}
