package myfan.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.AddDiscRequest;
import myfan.resources.base.AddSongRequest;
import myfan.resources.base.DeleteNewsRequest;

@Path("v1/disc")
public class DiscResource {

  @POST
  @Path("/addDisc")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addDisc(AddDiscRequest addDiscRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.addDisc(addDiscRequest); 
  }
  
  @POST
  @Path("/addSong")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addSong(AddSongRequest addSongRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.addSong(addSongRequest);
  }

  @POST
  @Path("/delete")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteNews(DeleteNewsRequest deleteNewsRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.deleteNews(deleteNewsRequest);
  }
}
