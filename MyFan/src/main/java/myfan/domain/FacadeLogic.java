/**
 * 
 */
package myfan.domain;

import java.io.File;
import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import myfan.resources.base.LoginRequest;
import myfan.resources.base.RegisterNewArtistRequest;
import myfan.resources.base.RegisterNewFanaticRequest;

/**
 * @author Javier
 *
 */
public class FacadeLogic {
	private UserLogic userLogic;
	private FanaticLogic fanaticLogic;
	private ArtistLogic artistLogic;

	public FacadeLogic() {
		userLogic = new UserLogic();
		fanaticLogic=new FanaticLogic();
		artistLogic=new ArtistLogic();
	}

	public Response logIn(LoginRequest credentials) {
		return userLogic.logIn(credentials);
	}

	public Response registerNewFanatic(RegisterNewFanaticRequest fanaticData, InputStream profilePicture,FormDataContentDisposition fileDetail) {
		String pathProfilePicture=userLogic.saveProfilePictureFile(profilePicture, fileDetail);
		return fanaticLogic.registerNewFanatic(fanaticData,pathProfilePicture);
	}

	public Response registerNewArtist(RegisterNewArtistRequest artistData, InputStream profilePicture,FormDataContentDisposition fileDetail) {
		String pathProfilePicture=userLogic.saveProfilePictureFile(profilePicture, fileDetail);
		return artistLogic.registerNewArtist(artistData,pathProfilePicture);
		
	}

	public void disableProfile(Object userProfile) {
	}

	public void modifyDataProfile(Object user) {
	}

	public void addGenre(Object genre) {
	}

	// public void disableGenre(Object genre){}

	// public void enableGenre(Object genre){}

	public void createEvent(Object event) {
	}

	public void cancelEvent(Object event) {
	}

	public void createNews(Object news) {
	}

	public void deleteNews(Object news) {
	}

	public void addDisc(Object disc) {
	}

	// public void deleteDisc(Object disc){}

	public void addSong(Object song) {
	}

	// public void deleteSong(Object song){}

	public void followArtist(Object artistUser) {
		// publicar twitter
	}

	public void rateArtist(Object artistQualification) {
		// publicar twitter
	}

	public void rateDiscography(Object discographyQualification) {
	}

	public void rateEvent(Object eventQualification) {
	}

	public void unFollowArtist(Object artistUser) {
	}

	public void searchArtist(Object artist) {
	}
}
