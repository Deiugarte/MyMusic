package myfan.domain;

import java.util.ArrayList;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.data.models.Fanatics;
import myfan.data.models.FanaticsGenres;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
import myfan.resources.base.RegisterNewFanaticRequest;

public class FanaticLogic extends UserLogic {

	protected final String USER_IDENTIFIER_STATUS = "{\"UserId\": \"%s\", \"status\":\"%s\"}";
	protected final String ERROR_USER_FOUND = "{\"Error \": \"User found \"}";

	public FanaticLogic() {

	}

	public Response registerNewFanatic(RegisterNewFanaticRequest dataFanatic) {

		String response = USER_IDENTIFIER_STATUS;

		Users user = facadeDAO.findUserByLogin(dataFanatic.getLogin());
		if (existUser(user)) {
			return responseBuilder(ERROR_USER_FOUND);
		}
		Fanatics fanatic = new Fanatics();
		Ubications ubication = facadeDAO.findUbicationsById(dataFanatic.getCountryLocation());
		ArrayList<Genres> genders = new ArrayList<>();
		for (int i = 0; i < dataFanatic.getMusisicalGenres().size(); i++) {
			genders.add(facadeDAO.findGenderByName(dataFanatic.getMusisicalGenres().get(i)));
		}
		UsersRoles usersRoles = facadeDAO.getFanaticRole(); 
		user= new Users();
		user.setUsersRoles(usersRoles);
		user.setName(dataFanatic.getNameUser());
		user.setUbications(ubication);
		user.setPassword(dataFanatic.getPassword());
		user.setImage(dataFanatic.getProfilePicture());/* revisar */
		user.setCreationDate(calculateCurrentDate());
		user.setUsername(dataFanatic.getLogin());
		facadeDAO.saveUser(user);
		
		fanatic.setSex(dataFanatic.getGender());
		fanatic.setBirthday(dataFanatic.getBirthDate());
		user = facadeDAO.findUserByLogin(dataFanatic.getLogin());
		fanatic.setUsers(user);
		facadeDAO.saveFanatic(fanatic);
		FanaticsGenres fanaticsGenres = new FanaticsGenres();
		fanaticsGenres.setFanatics(fanatic);
		for (int i = 0; i < genders.size(); i++) {
			System.out.println(genders.get(i).getGenreId()+"   "+ genders.get(i).getName());
			fanaticsGenres.setGenres(genders.get(i));
			//fanaticsGenres.setFanaticGenreId(i);
			facadeDAO.saveFanaticGenre(fanaticsGenres);
		}
		
		Users newUser = facadeDAO.findUserByLogin(dataFanatic.getLogin());
		response = String.format(response, user.getUserId().toString(), "OK");
		return Response.status(Status.OK).entity(response).build();
	}

}