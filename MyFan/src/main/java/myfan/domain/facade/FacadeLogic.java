/**
 * 
 */
package myfan.domain.facade;

import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import myfan.domain.ArtistLogic;
import myfan.domain.DiscLogic;
import myfan.domain.EventsLogic;
import myfan.domain.FanaticLogic;
import myfan.domain.GenresLogic;
import myfan.domain.NewsLogic;
import myfan.domain.SongLogic;
import myfan.domain.UserLogic;
import myfan.domain.UtilsLogic;
import myfan.resources.base.AddEventRequest;
import myfan.resources.base.AddDiscRequest;
import myfan.resources.base.AddNewsRequest;
import myfan.resources.base.AddSongRequest;
import myfan.resources.base.AdminGenresRequest;
import myfan.resources.base.DeleteNewsRequest;
import myfan.resources.base.DisableAccountRequest;
import myfan.resources.base.FollowArtistRequest;
import myfan.resources.base.LoginRequest;
import myfan.resources.base.RegisterNewArtistRequest;
import myfan.resources.base.RegisterNewFanaticRequest;
import myfan.resources.base.UpdateProfileUserRequest;

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
	}

	/*************************************** RESPONSE ******************************************************/
	/*************************************** RESPONSE ******************************************************/

	public String getAllGenders() {
		return utilsLogic.getAllGenres();

	}

	public String getPersonalInformationOfUser(int idUserProfile) {
		return userLogic.getPersonalInformationOfUser(idUserProfile);
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
		return artistLogic.updateFanatic(modifiedDataUsers, pathProfilePicture);
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

	public void cancelEvent(Object event) { // falta atributo en
											// base!!!!!!!!!!!!!!!!
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

	public Response followArtist( FollowArtistRequest followArtistRequest) {
		return fanaticLogic.followArtist(followArtistRequest);
	}
	
	public Response unFollowArtist(FollowArtistRequest unFollowArtistRequest) {
		return fanaticLogic.unFollowArtist(unFollowArtistRequest);
	}
	public void rateArtist(Object artistQualification) {
		// publicar twitter
	}

	public void rateDiscography(Object discographyQualification) {
	}

	public void rateEvent(Object eventQualification) {
	}

	

	public void searchArtist(Object artist) {
	}

	// public void deleteDisc(Object disc){}

	// public void disableGenre(Object genre){}

	// public void enableGenre(Object genre){}

	// public void deleteSong(Object song){}

}
