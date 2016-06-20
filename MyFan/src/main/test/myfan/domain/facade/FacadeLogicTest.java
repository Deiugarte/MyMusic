package myfan.domain.facade;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import myfan.data.models.Members;
import myfan.resources.base.AddDiscRequest;
import myfan.resources.base.AddEventRequest;
import myfan.resources.base.AddNewsRequest;
import myfan.resources.base.AddSongRequest;
import myfan.resources.base.DisableAccountRequest;
import myfan.resources.base.FindArtistRequest;
import myfan.resources.base.FollowArtistRequest;
import myfan.resources.base.LoginRequest;
import myfan.resources.base.RegisterNewArtistRequest;
import myfan.resources.base.RegisterNewFanaticRequest;
import myfan.resources.base.UpdateProfileUserRequest;
import myfan.resources.base.util.Member;

public class FacadeLogicTest {
  FacadeLogic facadeLogic = new FacadeLogic();
  
  @Test
  public void getAllGenders(){
	  String genders = facadeLogic.getAllGenders();
	  System.out.println(genders);;
  }
  
  
  @Test
  public void getCalificationOfArtist(){
	  String calification = facadeLogic.getCalificationsOfArtist(11);
	  System.out.println(calification);
  }
  
  
  @Test
  public void searchArtist(){
	  FindArtistRequest  artist = new FindArtistRequest();
	  artist.setName("javesp");
	  artist.setNameGenre("Pop");
	  artist.setNameUbication("Zambia");
	  String searchArtist = facadeLogic.searchArtist(artist);
	  System.out.println(searchArtist);
  }
  
  @Test
  public void getPersonalInformationOfArtist(){
	  String personalInformation = facadeLogic.getPersonalInformationOfArtist(11);
	  System.out.println(personalInformation);
  }
  
  @Test
  public void getPersonalInformationOfFanatic(){
	  String personalInformation = facadeLogic.getPersonalInformationOfFanatic(11);
	  System.out.println(personalInformation);
  }
  
  @Test
  public void getAllUbications(){
	  String getAllUbicationsTest = facadeLogic.getAllUbications();
	  System.out.println(getAllUbicationsTest);
  }

  @Test
  public void getRecentNews() { 
    String newsArtistTest = facadeLogic.getRecentNews(12, 0);
    System.out.println(newsArtistTest);
  //  assertEquals(2, newsArtistTest);
  }
  
  @Test
  public void getRecentEvents(){
	  String getRecentEventsTest = facadeLogic.getRecentEvents(11, 0);
	  System.out.println(getRecentEventsTest);
  }
  
  @Test
  public void getDiscography(){
	  String getDiscographyTest = facadeLogic.getDiscography(11);
	  System.out.println(getDiscographyTest);
  }

  @Test
  public void login(){
	  LoginRequest loginRequest = new LoginRequest();
	  loginRequest.setLogin("javesp");
	  loginRequest.setPassword("123");
	  facadeLogic.logIn(loginRequest);
  }
  @Test
  public void registerFanatic(){
	  RegisterNewFanaticRequest fanaticRequest = new RegisterNewFanaticRequest();
	  fanaticRequest.setBirthDate("2016-06-12");
	  fanaticRequest.setCountryLocation("Costa Rica");
	  fanaticRequest.setGender(true);
	  fanaticRequest.setLogin("Test");
	  fanaticRequest.setNameUser("Test");
	  ArrayList<String> musisicalGenres = new ArrayList<String>();
	  musisicalGenres.add("Rock");
	  fanaticRequest.setMusicalGenres(musisicalGenres);
	  fanaticRequest.setPassword("Test");
	  facadeLogic.registerNewFanatic(fanaticRequest, null, null);  
  } 
  
  @Test
  public void registerArtist(){
	  RegisterNewArtistRequest artistRequest = new RegisterNewArtistRequest();
	  artistRequest.setBiographyArtist("Test");
	  artistRequest.setBirthDate("2016-06-12");
	  artistRequest.setCountryLocation("Costa Rica");
	  artistRequest.setLogin("Test");
	  artistRequest.setNameUser("Test");
	  ArrayList<String> musisicalGenres = new ArrayList<String>();
	  musisicalGenres.add("Rock");
	  artistRequest.setMusicalGenres(musisicalGenres);
	  ArrayList<Member> members = new ArrayList<Member>();
	  Member members2 = new Member();
	  members2.setInstrument("Test");
	  members2.setName("Test");
	  members.add(members2);
	  artistRequest.setMembers(members);
	  artistRequest.setPassword("Test");
	  facadeLogic.registerNewArtist(artistRequest, null, null);
  }
  @Test
  public void disableProfile(){
	  DisableAccountRequest accountRequest = new DisableAccountRequest();
	  accountRequest.setLogin("javesp");
	  facadeLogic.disableProfile(accountRequest);
  }
 // @Test
 public void modifyData(){
	 UpdateProfileUserRequest updateProfileUserRequest = new UpdateProfileUserRequest();
	 updateProfileUserRequest.setBirthday("2016-02-02");
	 updateProfileUserRequest.setCountryLocation("Costa Rica");
	 updateProfileUserRequest.setGender(true);
	 updateProfileUserRequest.setNameUser("Test");
	 updateProfileUserRequest.setNameUser("Test");
	 facadeLogic.modifyDataArtist(updateProfileUserRequest, null, null);
 }
  
  @Test
  public void createNews() {
    AddNewsRequest addNewsRequest = new AddNewsRequest();
    addNewsRequest.setContentNews("Contenido Noticia test");
    addNewsRequest.setDateNews("2016-02-02");
    addNewsRequest.setIdUser(10);
    addNewsRequest.setTitleNews("Test");
   // assertEquals(1, facadeLogic.createNews(addNewsRequest));
  }
  
  @Test
  public void createEvent() {
    AddEventRequest addEventRequest = new AddEventRequest();
    addEventRequest.setContentEvent("Contenido Evento test");
    addEventRequest.setDateEvent("2016-02-02");
    addEventRequest.setIsConcert(true);
    addEventRequest.setUbicationEvent("Costa Rica");
    addEventRequest.setIdUser(10);
    addEventRequest.setTitleEvent("Test");
   // assertEquals(1, facadeLogic.createEvent(addEventRequest));
  }
  
  @Test
  public void addDisc() {
    AddDiscRequest addDiscRequest = new AddDiscRequest();
    addDiscRequest.setIdUser(10);
    addDiscRequest.setReleaseYear("2016-02-02");
    addDiscRequest.setDescriptionDisc("Creacion Disco Test");
    addDiscRequest.setLabel("Test");
    addDiscRequest.setNameGenre("Rock");
    addDiscRequest.setNameDisc("Test Disc");
  //  assertEquals(1, facadeLogic.addDisc(addDiscRequest));
  }
  
  @Test
  public void addSong() {
    AddSongRequest addSongRequest = new AddSongRequest();
    addSongRequest.setIdDisc(1);
    addSongRequest.setDurationSong("00:05:10");
    addSongRequest.setIsLimitEdition(true);
    addSongRequest.setIsLife(true);
    addSongRequest.setNameSong("Test");
    addSongRequest.setVideoLink("https://www.youtube.com/watch?v=jgpJVI3tDbY");
  //  assertEquals(1, facadeLogic.addSong(addSongRequest));
  } 


}
