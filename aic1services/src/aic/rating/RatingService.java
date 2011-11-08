package aic.rating;

import aic.domain.dto.RequestRatings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Produces("application/json")
@Path("rating")
public interface RatingService {
	/**
	 * Get the ratings for a given request
	 * @param requestId
	 * @return The ratings of the requests customer and his warrantors
	 */
    @GET
    @Path("{id}")
	public RequestRatings getRequestRatings(@PathParam("id") long requestId);
}
