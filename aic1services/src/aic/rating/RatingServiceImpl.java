package aic.rating;

import aic.domain.Rating;
import aic.domain.dto.RequestRatings;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.LinkedList;

public class RatingServiceImpl implements RatingService {
	public RequestRatings getRequestRatings(@PathParam("id") long requestId) {
		LinkedList<Rating> ratings = new LinkedList<Rating>();
		ratings.add(Rating.A);
		ratings.add(Rating.AAMinus);
		return new RequestRatings(Rating.Defaulting, ratings);
	}
}
