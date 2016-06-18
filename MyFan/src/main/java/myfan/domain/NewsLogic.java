package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.News;
import myfan.resources.base.RecentNewsResponse;

public class NewsLogic {
	private FacadeDAO facadeDAO;
	private JSON json;
	
	public NewsLogic(){
		facadeDAO = new FacadeDAO();
		json = new JSON();
	}

	
	public String getRecentNewsOfArtist(int idUser, int offset) {
		Artists artist= facadeDAO.findArtistByUserId(idUser);
		List <News> newsList=facadeDAO.getNewsByArtistId(artist.getArtistId(), offset);
		ArrayList<RecentNewsResponse> listResponse = new ArrayList<RecentNewsResponse>();
		for (int i = 0; i < newsList.size(); i++) {
			RecentNewsResponse recentNewsResponse = new RecentNewsResponse();
			recentNewsResponse.setContentNews(newsList.get(i).getContent());
			recentNewsResponse.setCreationDate(newsList.get(i).getCreationDate().toString());
			recentNewsResponse.setDateOfNews(newsList.get(i).getDate().toString());
			recentNewsResponse.setIdNews(newsList.get(i).getNewsId());
			recentNewsResponse.setTitleNews(newsList.get(i).getTittle());
			listResponse.add(recentNewsResponse);
		}
		return json.jsonConverter(listResponse);
	}
}
