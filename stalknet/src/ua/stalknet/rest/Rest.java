package ua.stalknet.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@ApplicationScoped
@Path("/test")
public class Rest {
  @GET
  @Path("/echo")
  public String echo(@QueryParam("param") @DefaultValue("") String param) {
    return "<H2>"+param+"</H2>";
  }
}
