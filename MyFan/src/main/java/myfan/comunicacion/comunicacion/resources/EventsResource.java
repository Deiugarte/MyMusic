package myfan.comunicacion.comunicacion.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myfan.controller.request.AddEventRequest;
import myfan.controller.request.CancelEventRequest;
import myfan.controller.request.DeleteNewsRequest;
import myfan.controller.request.GetEventsRequest;
import myfan.domain.facade.FacadeLogic;

@Path("v1/events")
public class EventsResource {

  @POST
  @Path("/getRecent")
  @Produces(MediaType.APPLICATION_JSON)
  public String getRecentEventsList(GetEventsRequest getEventsRequest) {
    FacadeLogic facadeLogic  = new FacadeLogic();
    return facadeLogic.getRecentEvents(getEventsRequest.getIdUser(), getEventsRequest.getOffset());    
  }
  
  @POST
  @Path("/add")
  @Produces(MediaType.APPLICATION_JSON)
  public Response addNewEvents(AddEventRequest addEventsRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.createEvent(addEventsRequest);
  }

  @POST
  @Path("/cancel")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteEvent(CancelEventRequest cancelEventRequest) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.cancelEvent(cancelEventRequest);
  }
  
  
}
