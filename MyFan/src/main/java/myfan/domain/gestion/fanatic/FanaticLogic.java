package myfan.domain.gestion.fanatic;

import java.util.ArrayList;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.controller.request.RegisterNewFanaticRequest;
import myfan.controller.request.UpdateProfileUserRequest;
import myfan.data.models.Fanatics;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
import myfan.domain.gestion.UserLogic;

public class FanaticLogic extends UserLogic {



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
		Fanatics fanatic = facadeDAO.findFanaticByUserId((dataFanatic.getIdentificationNumber()));
		Boolean gender= new Boolean(dataFanatic.isGender());
		System.out.println(fanatic.getFanaticId());
		if(gender!=null){
		  fanatic.setSex(gender.booleanValue());
		}
		facadeDAO.saveFanatic(fanatic);
		response = String.format(response, fanatic.getFanaticId().toString(), "fanatic", "OK");
		return Response.status(Status.OK).entity(response).build();

	}
	public String getPersonalInformationOfFanatic(int idUser){
		return getPersonalInformationOfUser(idUser);
	}
	

	
	


}
