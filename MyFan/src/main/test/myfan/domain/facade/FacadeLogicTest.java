package myfan.domain.facade;

import static org.junit.Assert.*;

import org.junit.Test;

import myfan.resources.base.AddDiscRequest;
import myfan.resources.base.AddEventRequest;
import myfan.resources.base.AddNewsRequest;
import myfan.resources.base.AddSongRequest;

public class FacadeLogicTest {
  FacadeLogic facadeLogic = new FacadeLogic();

  @Test
  public void getRecentNews() { 
    String newsArtistTest = facadeLogic.getRecentNews(12, 0);
    System.out.println(newsArtistTest);
    assertEquals(2, newsArtistTest);
  }

  @Test
  public void createNews() {
    AddNewsRequest addNewsRequest = new AddNewsRequest();
    addNewsRequest.setContentNews("Contenido Noticia test");
    addNewsRequest.setDateNews("2016-02-02");
    addNewsRequest.setIdUser(10);
    addNewsRequest.setTitleNews("Test");
    assertEquals(1, facadeLogic.createNews(addNewsRequest));
  }
  
  @Test
  public void createEvent() {
    AddEventRequest addEventRequest = new AddEventRequest();
    addEventRequest.setContentEvent("Contenido Evento test");
    addEventRequest.setDateEvent("2016-02-02");
    addEventRequest.setConcert(true);
    addEventRequest.setUbicationEvent("Costa Rica");
    addEventRequest.setIdUser(10);
    addEventRequest.setTitleEvent("Test");
    assertEquals(1, facadeLogic.createEvent(addEventRequest));
  }
  
  @Test
  public void addDisc() {
    AddDiscRequest addDiscRequest = new AddDiscRequest();
    addDiscRequest.setIdUser(10);
    addDiscRequest.setReleaseYear("2016-02-02");
    addDiscRequest.setDescriptionDisc("Creacion Disco Test");
    addDiscRequest.setLabel("Test");
    addDiscRequest.setIdGenre(11);
    addDiscRequest.setNameDisc("Test Disc");
    assertEquals(1, facadeLogic.addDisc(addDiscRequest));
  }
  
  @Test
  public void addSong() {
    AddSongRequest addSongRequest = new AddSongRequest();
    addSongRequest.setIdDisc(1);
    addSongRequest.setDurationSong("00:05:10");
    addSongRequest.setIsLimitEdition("true");
    addSongRequest.setLife(true);
    addSongRequest.setNameSong("Test");
    addSongRequest.setVideoLink("https://www.youtube.com/watch?v=jgpJVI3tDbY");
    assertEquals(1, facadeLogic.addSong(addSongRequest));
  }

}
