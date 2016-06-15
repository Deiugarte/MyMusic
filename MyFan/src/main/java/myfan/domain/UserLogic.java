package myfan.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Genres;
import myfan.data.models.Ubications;
import myfan.data.models.Users;
import myfan.data.models.UsersGenres;
import myfan.data.models.UsersRoles;
import myfan.resources.base.LoginRequest;

public class UserLogic {

	private final String DATE_FORMAT = "dd/MM/yyyy";
	protected final String USER_IDENTIFIER_STATUS = "{\"UserId\": \"%s\", \"status\":\"%s\"}";
	protected final String ERROR_USER_FOUND = "{\"Error \": \"User found \"}";
	protected final String ROLE_IDENTIFIER_STATUS = "{\"RoleIdentifier\": \"%s\", \"status\":\"%s\"}";
	protected final String ERROR_USER_ROLE_NOT_FOUND = "{\"Error \": \"UserRole not found \"}";
	protected final String ERROR_WRONG_PASSWORD = "{\"Error \": \"Wrong Password \"}";
	protected final String ERROR_USER_NOT_FOUND = "{\"Error \": \"User not found \"}";
	private final int ADMIN = 10;
	private final int FANATIC = 12;
	private final int BAND = 11;
	private Image image;

	protected FacadeDAO facadeDAO;

	public UserLogic() {
		facadeDAO = new FacadeDAO();
		image = new Image();

	}

	public Response logIn(LoginRequest credentials) {
		String response = ROLE_IDENTIFIER_STATUS;

		Users user = facadeDAO.findUserByLogin(credentials.getLogin());

		if (!existUser(user)) {
			return responseBuilder(ERROR_USER_NOT_FOUND);
		}

		if (!isValidPassword(credentials.getPassword(), user)) {
			return responseBuilder(ERROR_WRONG_PASSWORD);
		}

		UsersRoles userRole = user.getUsersRoles();

		if (!existRole(userRole)) {
			return responseBuilder(ERROR_USER_ROLE_NOT_FOUND);
		}
		response = determiningRole(response, userRole);
		response = String.format(response, user.getUsersRoles().getUsersRolesId(), "OK");
		return Response.status(Status.OK).entity(response).build();

	}

	public String saveProfilePictureFile(InputStream profilePicture, FormDataContentDisposition fileDetail) {
		return image.saveFile(profilePicture, fileDetail);

	}

	private boolean existRole(UsersRoles userRole) {
		return userRole != null;
	}

	private boolean isValidPassword(String password, Users user) {
		return user.getPassword().equals(password);
	}

	private String determiningRole(String response, UsersRoles userRole) {
		switch (userRole.getUsersRolesId()) {
		case ADMIN:
			response = String.format(response, userRole.getUsersRolesId(), "OK");
			break;
		case FANATIC:
			response = String.format(response, userRole.getUsersRolesId(), "OK");
			break;
		case BAND:
			response = String.format(response, userRole.getUsersRolesId(), "OK");
			break;
		}
		return response;
	}

	protected Response responseBuilder(String response) {
		return Response.status(Status.UNAUTHORIZED).entity(response).build();
	}

	protected boolean existUser(Users user) {
		return user != null;
	}

	protected Date calculateCurrentDate() {
		String currentDate;
		Date date = null;
		Calendar currentDateComputer = Calendar.getInstance();
		DateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
		currentDate = dateFormatter.format(currentDateComputer.getTime());
		try {
			date = dateFormatter.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	protected Ubications checkUbication(String userUbication) {
		Ubications ubication = facadeDAO.findUbicationsById(userUbication);
		return ubication;
	}

	protected ArrayList<Genres> checkGenres(ArrayList<String> genresList) {
		if (genresList != null) {
			ArrayList<Genres> genders = new ArrayList<>();
			for (int i = 0; i < genresList.size(); i++) {
				genders.add(facadeDAO.findGenderByName(genresList.get(i)));
			}
			return genders;
		} else {
			return null;
		}
	}

	protected void createUser(String pathProfilePicture, Ubications ubication, UsersRoles usersRoles, String nameUser,
			String password, String login, Date birthday) {
		Users user;
		user = new Users();
		user.setUsersRoles(usersRoles);
		user.setName(nameUser);
		user.setUbications(ubication);
		user.setPassword(password);
		user.setImage(pathProfilePicture);
		user.setCreationDate(calculateCurrentDate());
		user.setUsername(login);
		user.setBirthday(birthday);
		facadeDAO.saveUser(user);
	}

	protected void saveGenres(Users user, ArrayList<Genres> gendersList) {
		UsersGenres usersGenres;
		if (gendersList!=null){
		for (int i = 0; i < gendersList.size(); i++) {
			usersGenres = new UsersGenres();
			usersGenres.setUsers(user);
			usersGenres.setGenres(gendersList.get(i));
			facadeDAO.saveUsersGenres(usersGenres);
		}}else{
			facadeDAO.saveUsersGenres(null);
			
		}
	}

}
