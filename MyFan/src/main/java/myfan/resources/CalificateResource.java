package myfan.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myfan.domain.facade.FacadeLogic;
import myfan.resources.base.FollowArtistRequest;
import myfan.resources.base.RateArtistRequest;
import myfan.resources.base.RateConcertRequest;
import myfan.resources.base.RateDiscRequest;

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
