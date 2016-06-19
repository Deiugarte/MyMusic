package myfan.heroku;

import myfan.data.dao.FanaticsArtistsDao;
import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.FollowArtistRequest;
import myfan.resources.base.RateArtistRequest;

public class MainTest1 {

	public static void main(String[] args) {
		FacadeLogic facadeLogic = new FacadeLogic();
	
		
		RateArtistRequest artistRequest = new RateArtistRequest();
		artistRequest.setComment("Test");
		artistRequest.setIdUserArtist(10);
		artistRequest.setIdUserFanatic(12);
		artistRequest.setQualification(4);
		facadeLogic.rateArtist(artistRequest);
	}

}
