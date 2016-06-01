package myfan.resources;

import java.io.StringReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import myfan.data.models.Users;
import myfan.data.models.UsersRoles;
import myfan.resources.base.LoginRequest;
import myfan.services.AuthenticationService;

@Path("v1/auth")
public class AuthenticationResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public String authenticate(LoginRequest credentials) {

       return "";
    }
    
}
