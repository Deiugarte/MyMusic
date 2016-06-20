package myfan.heroku;

import myfan.domain.facade.FacadeLogic;

public class MainTest1 {

	public static void main(String[] args) {
		FacadeLogic facadeLogic = new FacadeLogic();
		System.out.println(facadeLogic.getCalificationsOfArtist(10));

	}

}
