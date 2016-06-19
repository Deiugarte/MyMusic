package myfan.heroku;

import myfan.data.dao.FanaticsArtistsDao;
import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.FollowArtistRequest;
import myfan.resources.base.RateArtistRequest;

public class MainTest1 {

	public static void main(String[] args) {
		FacadeLogic facadeLogic = new FacadeLogic();
		facadeLogic.getRecentNews(12, 1);
	
	}

}
