package myfan.comunicacion.comunicacion.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myfan.controller.request.FollowArtistRequest;
import myfan.controller.request.RateArtistRequest;
import myfan.controller.request.RateConcertRequest;
import myfan.controller.request.RateDiscRequest;
import myfan.domain.facade.FacadeLogic;

@Path("/calificate")
public class CalificateResource {
  
  
  @POST
  @Path("/artist")
  @Produces(MediaType.APPLICATION_JSON)
  public Response calificateArtist(RateArtistRequest rateArtistRequest ) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.rateArtist(rateArtistRequest);    
  }
  
  @POST
  @Path("/event")
  @Produces(MediaType.APPLICATION_JSON)
  public Response calificateEvent(RateConcertRequest rateConcertRequest ) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.rateEvent(rateConcertRequest);    
  }
  
  @POST
  @Path("/disc")
  @Produces(MediaType.APPLICATION_JSON)
  public Response calificateDisc(RateDiscRequest rateDiscRequest ) {
    FacadeLogic facadeLogic = new FacadeLogic();
    return facadeLogic.rateDiscography(rateDiscRequest);
    }
}
