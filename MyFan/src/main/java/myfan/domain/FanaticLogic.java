package myfan.domain;

import java.util.ArrayList;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.data.models.Artists;
import myfan.data.models.Fanatics;
import myfan.data.models.FanaticsArtists;
import myfan.data.models.FanaticsArtistsId;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
import myfan.resources.base.FollowArtistRequest;
import myfan.resources.base.RegisterNewFanaticRequest;
import myfan.resources.base.UpdateProfileUserRequest;

public class FanaticLogic extends UserLogic {

	private static final int ONE_FOLLOW = 1;
	private final String FOLLOW_ARTIST_STATUS = "{ \"status\":\"%s\"}";
	private final String UNFOLLOW_ARTIST_STATUS = "{ \"status\":\"%s\"}";
	private final String ERROR_ARTIST_NOT_FOUND = "{\"Error \": \"Artist not found \"}";
	private final String ERROR_FANATIC_NOT_FOUND = "{\"Error \": \"Fanatic not found \"}";
	private final int STATUS_RATE = 0;
	private final int STATUS_FOLLOW = 1;
	private final int STATUS_RATE_AND_COMMENT = 2;

	public Response registerNewFanatic(RegisterNewFanaticRequest dataFanatic, String pathProfilePicture) {

		String response = USER_IDENTIFIER_STATUS;
		Users user = facadeDAO.findUserByLogin(dataFanatic.getLogin());
		if (existUser(user)) {
			return responseBuilder(ERROR_USER_FOUND);
		}
		Ubications ubication = checkUbication(dataFanatic.getCountryLocation());
		ArrayList<Genres> genders = checkGenres(dataFanatic.getMusicalGenres());
		UsersRoles usersRoles = facadeDAO.getFanaticRole();

		createUser(pathProfilePicture, ubication, usersRoles, dataFanatic.getNameUser(), dataFanatic.getPassword(),
				dataFanatic.getLogin(), dataFanatic.getBirthDate());

		Fanatics fanatic = new Fanatics();
		user = facadeDAO.findUserByLogin(dataFanatic.getLogin());
		fanatic.setSex(dataFanatic.getGender());
		fanatic.setUsers(user);
		facadeDAO.saveFanatic(fanatic);
		saveGenres(user, genders);

		response = String.format(response, user.getUserId().toString(), user.getUsersRoles().getRoleName(), "OK");
		return Response.status(Status.OK).entity(response).build();
	}

	public Response updateFanatic(UpdateProfileUserRequest dataFanatic, String pathProfilePicture) {
		String response = USER_IDENTIFIER_STATUS;
		updateUser(dataFanatic, pathProfilePicture);
		Fanatics fanatic = facadeDAO.findFanaticById(dataFanatic.getIdentificationNumber());
		fanatic.setSex(dataFanatic.isGender());
		facadeDAO.saveFanatic(fanatic);
		response = String.format(response, fanatic.getFanaticId().toString(), "fanatic", "OK");
		return Response.status(Status.OK).entity(response).build();

	}

	public Response followArtist(FollowArtistRequest followArtistRequest) {
		String response = FOLLOW_ARTIST_STATUS;
		Fanatics fanatic = facadeDAO.findFanaticById(followArtistRequest.getIdUserFanatic());
		Artists artists = facadeDAO.findArtistById(followArtistRequest.getIdUserArtist());
		FanaticsArtists fanaticsArtists = new FanaticsArtists();
		fanaticsArtists.setArtists(artists);
		fanaticsArtists.setFanatics(fanatic);
		FanaticsArtistsId fanaticsArtistsId = new FanaticsArtistsId();
		fanaticsArtistsId.setArtistId(artists.getArtistId());
		fanaticsArtistsId.setFanaticId(fanatic.getFanaticId());
		fanaticsArtists.setId(fanaticsArtistsId);
		facadeDAO.saveFanaticsArtist(fanaticsArtists);
		increaseFollowers(artists);
		TwitterLogic twitter = new TwitterLogic();
		twitter.postTwitter(fanatic, artists, STATUS_FOLLOW);
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
		Fanatics fanatic = facadeDAO.findFanaticById(unFollowArtistRequest.getIdUserFanatic());
		Artists artists = facadeDAO.findArtistById(unFollowArtistRequest.getIdUserArtist());
		facadeDAO.deleteFollowersOfArtist(fanatic.getFanaticId(), artists.getArtistId());
		decreaseFollowers(artists);
		response = String.format(response, "OK");
		return Response.status(Status.OK).entity(response).build();
	}
}
