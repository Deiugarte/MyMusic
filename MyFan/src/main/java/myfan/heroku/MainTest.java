package myfan.heroku;

import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.AddNewsRequest;

public class MainTest {

  public static void main(String[] args) {
    FacadeLogic facadeLogic = new FacadeLogic();

	
    //System.out.println(facadeLogic.getRecentEvents(12, 0));
   
  //  System.out.println(facadeLogic.getRecentEvents(10, 0));
    
    AddNewsRequest addNewsRequest=new AddNewsRequest();
	addNewsRequest.setContentNews("Contenido Noticia test");
	addNewsRequest.setDateNews("2016-02-02");
	addNewsRequest.setIdUser(10);
	addNewsRequest.setTitleNews("Test");
	facadeLogic.createNews(addNewsRequest);
	
	System.out.println("Soy el puto amo");
  }
}


