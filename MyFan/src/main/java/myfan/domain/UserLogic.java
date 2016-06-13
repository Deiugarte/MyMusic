package myfan.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.data.facade.FacadeDAO;
import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
import myfan.resources.base.LoginRequest;

public class UserLogic {

	private   final String DATE_FORMAT = "yyyy/MM/dd";
	protected final String ROLE_IDENTIFIER_STATUS = "{\"RoleIdentifier\": \"%s\", \"status\":\"%s\"}";
	protected final String ERROR_USER_ROLE_NOT_FOUND = "{\"Error \": \"UserRole not found \"}";
	protected final String ERROR_WRONG_PASSWORD = "{\"Error \": \"Wrong Password \"}";
	protected final String ERROR_USER_NOT_FOUND = "{\"Error \": \"User not found \"}";
	private final int ADMIN = 10;
	private final int FANATIC = 12;
	private final int BAND = 11;
	
	protected FacadeDAO facadeDAO;

	public UserLogic() {
		facadeDAO = new FacadeDAO();

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
		response = String.format(response, user.getUsersRoles().getUserRoleId(), "OK");
		return Response.status(Status.OK).entity(response).build();

	}

	private boolean existRole(UsersRoles userRole) {
		return userRole != null;
	}

	private boolean isValidPassword(String password, Users user) {
		return user.getPassword().equals(password);
	}

	private String determiningRole(String response, UsersRoles userRole) {
		switch (userRole.getUserRoleId()) {
		case ADMIN:
			response = String.format(response, userRole.getUserRoleId(), "OK");
			break;
		case FANATIC:
			response = String.format(response, userRole.getUserRoleId(), "OK");
			break;
		case BAND:
			response = String.format(response, userRole.getUserRoleId(), "OK");
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
		DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		currentDate = dateFormatter.format(currentDateComputer.getTime());
		try {
			date =dateFormatter.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  date;
	}
}
