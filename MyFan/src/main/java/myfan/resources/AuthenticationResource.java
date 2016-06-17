package myfan.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.LoginRequest;

@Path("v1/auth")
public class AuthenticationResource {
	
  private  FacadeLogic facadeLogic = new FacadeLogic();

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/login")
  public Response authenticate(LoginRequest credentials) {
	  return  facadeLogic.logIn(credentials);

  }

}
