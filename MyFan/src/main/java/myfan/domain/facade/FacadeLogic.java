/**
 * 
 */
package myfan.domain.facade;

import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import myfan.controller.request.AddDiscRequest;
import myfan.controller.request.AddEventRequest;
import myfan.controller.request.AddNewsRequest;
import myfan.controller.request.AddSongRequest;
import myfan.controller.request.AdminGenresRequest;
import myfan.controller.request.CancelEventRequest;
import myfan.controller.request.DeleteNewsRequest;
import myfan.controller.request.DisableAccountRequest;
import myfan.controller.request.FindArtistRequest;
import myfan.controller.request.FollowArtistRequest;
import myfan.controller.request.LoginRequest;
import myfan.controller.request.RateArtistRequest;
import myfan.controller.request.RateConcertRequest;
import myfan.controller.request.RateDiscRequest;
import myfan.controller.request.RegisterNewArtistRequest;
import myfan.controller.request.RegisterNewFanaticRequest;
import myfan.controller.request.UpdateProfileUserRequest;
import myfan.data.models.Artists;
import myfan.domain.gestion.genres.GenresLogic;
import myfan.domain.gestion.news.NewsLogic;
import myfan.domain.gestion.search.Search;
import myfan.domain.gestion.utils.UtilsLogic;
import myfan.domain.gestion.ActionsUser;
import myfan.domain.gestion.UserLogic;
import myfan.domain.gestion.artist.ArtistLogic;
import myfan.domain.gestion.artist.CommnetsArtist;
import myfan.domain.gestion.artist.FollowedArtist;
import myfan.domain.gestion.discography.DiscLogic;
import myfan.domain.gestion.discography.DiscographyLogic;
import myfan.domain.gestion.discography.SongLogic;
import myfan.domain.gestion.events.CommentsConcert;
import myfan.domain.gestion.events.CommentsDisc;
import myfan.domain.gestion.events.EventsLogic;
import myfan.domain.gestion.fanatic.FanaticLogic;

/**
 * @author Javier
 *
 */
public class FacadeLogic {
	private UserLogic userLogic;
	private FanaticLogic fanaticLogic;
	private ArtistLogic artistLogic;
	private UtilsLogic utilsLogic;
	private GenresLogic genresLogic;
	private NewsLogic newsLogic;
	private EventsLogic eventsLogic; 
	private DiscLogic discLogic;
	private SongLogic songLogic;
	private ActionsUser actionsUser;
	private Search search;
	private FollowedArtist  followedArtist;
	private CommnetsArtist commentsArtist;
	private DiscographyLogic discographyLogic;
	private CommentsDisc commentsDisc;
	private CommentsConcert commentsConcert;

	public FacadeLogic() {
		userLogic = new UserLogic();
		fanaticLogic = new FanaticLogic();
		artistLogic = new ArtistLogic();
		utilsLogic = new UtilsLogic();
		genresLogic = new GenresLogic();
		newsLogic = new NewsLogic();
		eventsLogic = new EventsLogic();
		discLogic = new DiscLogic();
		songLogic = new SongLogic();
		actionsUser = new ActionsUser();
		search = new Search();
		followedArtist = new FollowedArtist();
		commentsArtist = new CommnetsArtist();
		discographyLogic = new DiscographyLogic();
		commentsDisc= new CommentsDisc();
		commentsConcert=new CommentsConcert();
	}

	/*************************************** RESPONSE ******************************************************/
	/*************************************** RESPONSE ******************************************************/

	public String getAllGenders() {
		return utilsLogic.getAllGenres();

	}
	
	public String getFollowedArtist(int idUser){
		return followedArtist.getFollowedArtist(idUser);
	}
	
	public String getCalificationsOfArtist(int idUser){
		return commentsArtist.getCalificationsOfArtist(idUser);
	}
	
	public String getCalificationsOfDisc(int idDisc){
		return commentsDisc.getCalificationsOfDisc(idDisc);
	}
	
	public String getCalificationsOfConcert(int idEvent){
		return commentsConcert.getCalificationsOfConcert(idEvent);
	}

	public String searchArtist(FindArtistRequest artist) {
		return search.searchArtist(artist);
	}

	public String getPersonalInformationOfFanatic(int idUserProfile) {
		return fanaticLogic.getPersonalInformationOfFanatic(idUserProfile);
	}
	

	public String getPersonalInformationOfArtist(int idUserProfile) {
		return artistLogic.getPersonalInformationOfArtist(idUserProfile);
	}

	public String getAllUbications() {
		return utilsLogic.getAllUbications();
	}

	public String getRecentNews(int idUser, int offset) {
		return newsLogic.getRecentNews(idUser, offset);
	}

	public String getRecentEvents(int idUser, int offset) {
		return eventsLogic.getRecentEvents(idUser, offset);
	}

	public String getDiscography(int idUser){
		return discographyLogic.getDiscography(idUser);
	}
	/*************************************** REQUEST ******************************************************/
	/*************************************** REQUEST ******************************************************/

	public Response logIn(LoginRequest credentials) {
		return userLogic.logIn(credentials);
	}

	public Response registerNewFanatic(RegisterNewFanaticRequest fanaticData, InputStream profilePicture,
			FormDataContentDisposition fileDetail) {
		String pathProfilePicture = userLogic.saveProfilePictureFile(profilePicture, fileDetail);
		return fanaticLogic.registerNewFanatic(fanaticData, pathProfilePicture);
	}

	public Response registerNewArtist(RegisterNewArtistRequest artistData, InputStream profilePicture,
			FormDataContentDisposition fileDetail) {
		String pathProfilePicture = userLogic.saveProfilePictureFile(profilePicture, fileDetail);
		return artistLogic.registerNewArtist(artistData, pathProfilePicture);
	}

	public Response disableProfile(DisableAccountRequest userProfile) {
		return userLogic.disableAccount(userProfile);
	}

	public Response modifyDataFanatic(UpdateProfileUserRequest modifiedDataUsers, InputStream profilePicture,
			FormDataContentDisposition fileDetail) {
		String pathProfilePicture = userLogic.saveProfilePictureFile(profilePicture, fileDetail);
		return fanaticLogic.updateFanatic(modifiedDataUsers, pathProfilePicture);
	}

	public Response modifyDataArtist(UpdateProfileUserRequest modifiedDataUsers, InputStream profilePicture,
	 FormDataContentDisposition fileDetail) {
		String pathProfilePicture = userLogic.saveProfilePictureFile(profilePicture, fileDetail);
		return artistLogic.updateArtist(modifiedDataUsers, pathProfilePicture);
		}

	public Response addGenre(AdminGenresRequest musicalGenres) {
		return genresLogic.addNewGenres(musicalGenres);
	}

	public Response createNews(AddNewsRequest news) {
		return newsLogic.createNews(news);
	}

	public Response deleteNews(DeleteNewsRequest idNews) {
		return newsLogic.deleteNews(idNews);
	}

	public Response cancelEvent(CancelEventRequest event) { 
		return eventsLogic.cancelEvent(event);
	}

	public Response createEvent(AddEventRequest event) {
		return eventsLogic.createEvent(event);
	}

	public Response addDisc(AddDiscRequest disc) {
		return discLogic.createDisc(disc);
	}

	public Response addSong(AddSongRequest song) {
		return songLogic.createSong(song);
	}

	public Response followArtist(FollowArtistRequest followArtistRequest) {
		return actionsUser.followArtist(followArtistRequest);
	}

	public Response unFollowArtist(FollowArtistRequest unFollowArtistRequest) {
		return actionsUser.unFollowArtist(unFollowArtistRequest);
	}

	public Response rateArtist(RateArtistRequest artistQualification) {
		return actionsUser.rateArtist(artistQualification);
	}

	public Response rateDiscography(RateDiscRequest discographyQualification) {
		return actionsUser.rateDisc(discographyQualification);
	}

	public Response rateEvent(RateConcertRequest eventQualification) {
		return actionsUser.rateConcert(eventQualification);									
	}
	
	public Response Following(FollowArtistRequest followArtistRequest){
		return utilsLogic.isFollowing(followArtistRequest);
	}


	 public void deleteDisc(Object disc){}

	 public void disableGenre(Object genre){}

	 public void enableGenre(Object genre){}

	 public void deleteSong(Object song){}

}
