package myfan.heroku;

import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.AdminGenresRequest;

public class MainTest {

  public static void main(String[] args) {
    FacadeLogic facadeLogic = new FacadeLogic();

	
	System.out.println(facadeLogic.getRecentNewsOfArtist(10, 0));
    System.out.println("Soy el puto amo");
  }
}


