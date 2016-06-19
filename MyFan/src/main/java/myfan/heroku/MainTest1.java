package myfan.heroku;

import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.FindArtistRequest;

public class MainTest1 {

	public static void main(String[] args) {
		FacadeLogic facadeLogic = new FacadeLogic();
		FindArtistRequest findArtistRequest= new FindArtistRequest();
		findArtistRequest.setName("");
		findArtistRequest.setNameGenere("Rock");
		findArtistRequest.setNameUbication("");
		System.out.println(facadeLogic.searchArtist(findArtistRequest));
	}

}
