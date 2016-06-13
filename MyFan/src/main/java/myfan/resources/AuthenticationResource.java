package myfan.resources;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
import myfan.resources.base.LoginRequest;
import myfan.services.AuthenticationService;

@Path("v1/auth")
public class AuthenticationResource {

  private static final Log LOGGER = LogFactory.getLog(AuthenticationResource.class);
  private static final int ADMIN = 10;
  private static final int FANATIC = 12;
  private static final int BAND = 11;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/login")
  public Response authenticate(LoginRequest credentials) {

    String response = "{\"RoleIdentifier\": \"%s\", \"status\":\"%s\"}";

    AuthenticationService authService = new AuthenticationService();
    Users user = authService.findUserByLogin(credentials.getLogin());
    if (user == null) {
      response = "{\"Error \": \"UserRole not found \"}";
      return Response.status(Status.UNAUTHORIZED).entity(response).build();
    }
    UsersRoles userRole = user.getUsersRoles();
    if (userRole == null) {
      response = "{\"Error \": \"UserRole not found \"}";
      return Response.status(Status.NO_CONTENT).entity(response).build();
    }
    if (!(user.getPassword().equals(credentials.getPassword()))) {
      response = "{\"Error \": \"Wrong Password \"}";
      return Response.status(Status.UNAUTHORIZED).entity(response).build();
    }
    
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
    response = String.format(response, user.getUsersRoles().getUsersRolesId(), "OK");
    return Response.status(200).entity(response).build();
  }

}
