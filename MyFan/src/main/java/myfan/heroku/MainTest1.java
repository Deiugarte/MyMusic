package myfan.heroku;

import myfan.data.dao.FanaticsArtistsDao;
import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.FollowArtistRequest;

public class MainTest1 {

	public static void main(String[] args) {
		FacadeLogic facadeLogic = new FacadeLogic();
		FollowArtistRequest followArtistRequest = new FollowArtistRequest();
		followArtistRequest.setIdUserArtist(2);
		followArtistRequest.setIdUserFanatic(1);
		facadeLogic.followArtist(followArtistRequest);
		FanaticsArtistsDao artistsDao = new FanaticsArtistsDao();
		System.out.println("----------------------------------");
		artistsDao.deleteByIdArtistAndIdFanatic(1, 1);
		System.out.println("----------------------------------");

	}

}
