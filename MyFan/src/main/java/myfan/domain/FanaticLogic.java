package myfan.domain;

import java.util.ArrayList;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.data.models.Fanatics;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
import myfan.resources.base.RegisterNewFanaticRequest;

public class FanaticLogic extends UserLogic {

	public Response registerNewFanatic(RegisterNewFanaticRequest dataFanatic, String pathProfilePicture) {

		String response = USER_IDENTIFIER_STATUS;
		Users user = facadeDAO.findUserByLogin(dataFanatic.getLogin());
		if (existUser(user)) {
			return responseBuilder(ERROR_USER_FOUND);
		}
		Ubications ubication = checkUbication(dataFanatic.getCountryLocation());
		ArrayList<Genres> genders = checkGenres(dataFanatic.getMusisicalGenres());
		UsersRoles usersRoles = facadeDAO.getFanaticRole();

		createUser(pathProfilePicture, ubication, usersRoles, dataFanatic.getNameUser(), dataFanatic.getPassword(),
				dataFanatic.getLogin(), dataFanatic.getBirthDate());

		Fanatics fanatic = new Fanatics();
		user = facadeDAO.findUserByLogin(dataFanatic.getLogin());
		fanatic.setSex(dataFanatic.getGender());
		fanatic.setUsers(user);
		facadeDAO.saveFanatic(fanatic);

		saveGenres(user, genders);

		response = String.format(response, user.getUserId().toString(), "OK");
		return Response.status(Status.OK).entity(response).build();
	}

}
