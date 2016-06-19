package myfan.heroku;

import myfan.domain.FollowedArtist;
import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.FindArtistRequest;
import myfan.resources.base.FollowedArtistResponse;

public class MainTest1 {

	public static void main(String[] args) {
		FacadeLogic facadeLogic = new FacadeLogic();
		System.out.println(facadeLogic.getFollowedArtist(12));
	}

}
