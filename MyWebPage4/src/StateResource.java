//The following class acts as Rest webservice for accessing state and city when required zip is provided.
import java.util.ArrayList;

import javax.annotation.Generated;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/State")
@ApplicationPath("/Webresources")
public class StateResource extends Application {

	@GET
	@Path("/zip")
	// @Path("{zip}")
	// @Produces("text/plain")
	public ArrayList<String> getstateandcity(@PathParam("zip") String zip) {
		ArrayList<String> statencity = new ArrayList<String>();
		if (zip.equals("22312")) {
			statencity.clear();
			statencity.add("Alexandria");
			statencity.add("VA");
		} else if (zip.equals("22030")) {
			statencity.clear();
			statencity.add("Fairfax");
			statencity.add("VA");

		} else if (zip.equals("22301")) {
			statencity.clear();
			statencity.add("Tysons Corner");
			statencity.add("MD");

		} else if (zip.equals("20148")) {
			statencity.clear();
			statencity.add("Ashburn");
			statencity.add("VA");

		}else{
			
			statencity.clear();
		}

		return statencity;

	}

}

/*
 * @XmlRootElement(name="zip") public class state{
 * 
 * }
 */
