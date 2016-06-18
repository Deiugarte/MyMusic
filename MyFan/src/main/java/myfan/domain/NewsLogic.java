package myfan.domain;

import java.util.ArrayList;
import java.util.List;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.FanaticsArtists;
import myfan.data.models.News;
import myfan.resources.base.RecentNewsResponse;

public class NewsLogic {
	private FacadeDAO facadeDAO;
	private JSON json;

	public NewsLogic() {
		facadeDAO = new FacadeDAO();
		json = new JSON();
	}

	public String getRecentNews(int idUser, int offset) {
		List<News> newsList = new ArrayList<News>();
		if (isArtist(idUser)) {
			newsList = getNewsArtist(idUser, offset);
		}
		else{
			newsList = getNewsFanatics(idUser, offset);
		}
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

	private boolean isArtist(int idUser) {
		return facadeDAO.findArtistByUserId(idUser) != null;
	}

	private List<News> getNewsArtist(int idUser, int offset) {
		List<News> newsList;
		int artistId = facadeDAO.findArtistByUserId(idUser).getArtistId();
		newsList = facadeDAO.getNewsByArtistId(artistId, offset);
		return newsList;
	}

	private List<News> getNewsFanatics(int idUser,int offset) {
		int fanaticId = facadeDAO.findFanaticByUserId(idUser).getFanaticId();
		List<FanaticsArtists> fanaticsArtistsList = facadeDAO.findArtistsByFanaticId(fanaticId);
		return facadeDAO.getNewsByArtistList(fanaticsArtistsList, offset);
	}

	
}
