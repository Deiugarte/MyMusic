package myfan.domain;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Artists;
import myfan.data.models.ArtistsCalifications;
import myfan.data.models.Discs;
import myfan.data.models.Fanatics;
import myfan.data.models.FanaticsArtists;
import myfan.data.models.FanaticsArtistsId;
import myfan.resources.base.FollowArtistRequest;
import myfan.resources.base.RateArtistRequest;
import myfan.resources.base.RateDiscRequest;

public class ActionsUser {

	private FacadeDAO facadeDAO;
	private TwitterLogic twitter;
	private final int ONE_FOLLOW = 1;
	private final String NO_COMMENT = "";
	private final String FOLLOW_ARTIST_STATUS = "{ \"status\":\"%s\"}";
	private final String UNFOLLOW_ARTIST_STATUS = "{ \"status\":\"%s\"}";
	private final String QUALIFICATION_ARTIST_STATUS = "{\"CommentId\": \"%s\", \"status\":\"%s\"}";

	public ActionsUser() {
		facadeDAO = new FacadeDAO();
		twitter = new TwitterLogic();
	}

	public Response followArtist(FollowArtistRequest followArtistRequest) {
		String response = FOLLOW_ARTIST_STATUS;
		Fanatics fanatic = facadeDAO.findFanaticByUserId(followArtistRequest.getIdUserFanatic());
		Artists artists = facadeDAO.findArtistByUserId(followArtistRequest.getIdUserArtist());
		FanaticsArtists fanaticsArtists = new FanaticsArtists();
		fanaticsArtists.setArtists(artists);
		fanaticsArtists.setFanatics(fanatic);
		FanaticsArtistsId fanaticsArtistsId = new FanaticsArtistsId();
		fanaticsArtistsId.setArtistId(artists.getArtistId());
		fanaticsArtistsId.setFanaticId(fanatic.getFanaticId());
		fanaticsArtists.setId(fanaticsArtistsId);
		facadeDAO.saveFanaticsArtist(fanaticsArtists);
		increaseFollowers(artists);
		twitter.postTwitter(fanatic, artists, twitter.STATUS_FOLLOW);
		response = String.format(response, "OK");
		return Response.status(Status.OK).entity(response).build();
	}

	private void increaseFollowers(Artists artists) {
		artists.setFollowers(artists.getFollowers() + ONE_FOLLOW);
		facadeDAO.saveArtist(artists);
	}

	private void decreaseFollowers(Artists artists) {
		artists.setFollowers(artists.getFollowers() - ONE_FOLLOW);
		facadeDAO.saveArtist(artists);
	}

	public Response unFollowArtist(FollowArtistRequest unFollowArtistRequest) {
		String response = UNFOLLOW_ARTIST_STATUS;
		Fanatics fanatic = facadeDAO.findFanaticByUserId(unFollowArtistRequest.getIdUserFanatic());
		Artists artists = facadeDAO.findArtistByUserId(unFollowArtistRequest.getIdUserArtist());
		facadeDAO.deleteFollowersOfArtist(fanatic.getFanaticId(), artists.getArtistId());
		decreaseFollowers(artists);
		response = String.format(response, "OK");
		return Response.status(Status.OK).entity(response).build();
	}

	public Response rateArtist(RateArtistRequest artistQualification) {
		String response = QUALIFICATION_ARTIST_STATUS;
		Fanatics fanatic = facadeDAO.findFanaticByUserId(artistQualification.getIdUserFanatic());
		Artists artists = facadeDAO.findArtistByUserId(artistQualification.getIdUserArtist());
		ArtistsCalifications artistsCalifications = new ArtistsCalifications();
		artistsCalifications.setCalification(artistQualification.getQualification());
		if (!artistQualification.getComment().equals(NO_COMMENT)) {
			artistsCalifications.setComment(artistQualification.getComment());
			twitter.postTwitter(fanatic, artists, twitter.STATUS_RATE_AND_COMMENT);
		} else {
			artistsCalifications.setComment(NO_COMMENT);
			twitter.postTwitter(fanatic, artists, twitter.STATUS_RATE);
		}
		artistsCalifications.setArtists(artists);
		artistsCalifications.setFanatics(fanatic);
		facadeDAO.saveCommentsForArtist(artistsCalifications);
		decreaseFollowers(artists);
		response = String.format(response, artistsCalifications.getArtistCalificationId(), "OK");
		return Response.status(Status.OK).entity(response).build();
	}
	public Response rateDisc(RateDiscRequest rateDiscRequest) {
		String response = QUALIFICATION_ARTIST_STATUS;
		Fanatics fanatic = facadeDAO.findFanaticByUserId(rateDiscRequest.getIdUserFanatic());
		Discs disc = facadeDAO.findDiscById(rateDiscRequest.getIdDisc());
	/*	ArtistsCalifications artistsCalifications = new ArtistsCalifications();
		artistsCalifications.setCalification(rateDiscRequest.getQualification());
		if (!rateDiscRequest.getComment().equals(NO_COMMENT)) {
			artistsCalifications.setComment(rateDiscRequest.getComment());
			twitter.postTwitter(fanatic, artists, twitter.STATUS_RATE_AND_COMMENT);
		} else {
			artistsCalifications.setComment(NO_COMMENT);
			twitter.postTwitter(fanatic, artists, twitter.STATUS_RATE);
		}
		artistsCalifications.setArtists(artists);
		artistsCalifications.setFanatics(fanatic);
		facadeDAO.saveCommentsForArtist(artistsCalifications);
		decreaseFollowers(artists);*/
		//response = String.format(response, artistsCalifications.getArtistCalificationId(), "OK");
		return Response.status(Status.OK).entity(response).build();
	}
	
	
}
