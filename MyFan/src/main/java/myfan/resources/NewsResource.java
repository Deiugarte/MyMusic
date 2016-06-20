package myfan.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.AddNewsRequest;
import myfan.resources.base.DeleteNewsRequest;
import myfan.resources.base.GetNewsRequest;

@Path("v1/news")
public class NewsResource {

  @POST
  @Path("/getRecent")
  @Produces(MediaType.APPLICATION_JSON)
  public String getRecentNewsList(GetNewsRequest getNewsRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    System.out.println(getNewsRequest.getIdUser()+"   "+ getNewsRequest.getOffset());
    return facadeLogic.getRecentNews(getNewsRequest.getIdUser(), getNewsRequest.getOffset());
  }
  
  @POST
  @Path("/add")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addNewNews(AddNewsRequest addNewsRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.createNews(addNewsRequest);
  }

  @POST
  @Path("/delete")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteNews(DeleteNewsRequest deleteNewsRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.deleteNews(deleteNewsRequest);
  }
}
