/**
 * 
 */
package myfan.domain;

import javax.ws.rs.core.Response;

import myfan.resources.base.LoginRequest;
import myfan.resources.base.RegisterNewFanaticRequest;

/**
 * @author Javier
 *
 */
public class FacadeLogic {
	private UserLogic userLogic;
	private FanaticLogic fanaticLogic;

	public FacadeLogic() {
		userLogic = new UserLogic();
		fanaticLogic=new FanaticLogic();
	}

	public Response logIn(LoginRequest credentials) {
		return userLogic.logIn(credentials);
	}

	public Response registerNewFanatic(RegisterNewFanaticRequest fanaticData) {
		return fanaticLogic.registerNewFanatic(fanaticData);
	}

	public void registerNewArtist(Object userCredentials) {
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
