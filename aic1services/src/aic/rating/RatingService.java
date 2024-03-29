package aic.rating;

import at.ac.tuwien.infosys.aic11.dto.RequestRatings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/rating")
@Produces("application/json")
public interface RatingService {
	/**
	 * Get the ratings for a given request
	 * @param requestId
	 * @return The ratings of the requests customer and his warrantors
	 */
	@GET
	@Path("/{id}")
	public RequestRatings getRequestRatings(@PathParam("id")long requestId);
}
