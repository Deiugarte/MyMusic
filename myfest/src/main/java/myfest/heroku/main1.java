package myfest.heroku;

import myfest.facade.FacadeGUI;

public class main1 {

	public static void main(String[] args) {
		FacadeGUI facadeGUI= new FacadeGUI();
		
		System.out.println(facadeGUI.getSearchArtistData(1));

	}

}
