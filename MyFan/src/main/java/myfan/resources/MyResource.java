package myfan.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import myfan.dao.AdministratorsDao;
import myfan.dao.AdministratorsHome;
import myfan.dao.FanaticsDao;
import myfan.models.Administrators;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
      AdministratorsDao asd= new AdministratorsDao();
      Administrators meh = new Administrators();
      meh.setLogin("Deiviadasd");
      meh.setPassword("asd");
      try {
        asd.save(meh);
      } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
      }
      
        return "Hola Valeria";
    }
}
