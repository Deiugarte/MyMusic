package myfan.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.AdminGenresRequest;

@Path("v1/genres")
public class GenresManagerResource {

  
  @POST
  @Path("/add")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addGenre(AdminGenresRequest adminGenresRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.addGenre(adminGenresRequest);
  }

 
}
