package de.dawid.webstreamer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/myresource")
public class MyResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getIt")
	public String getIt(){
		return "Damn, Got it!";
	}
}
