package aic.rating;

import aic.domain.Rating;
import at.ac.tuwien.infosys.aic11.dto.RequestRatings;

import javax.ws.rs.PathParam;
import java.util.LinkedList;

public class RatingServiceImpl implements RatingService {
	public RequestRatings getRequestRatings(@PathParam("id") long requestId) {
		LinkedList<Rating> ratings = new LinkedList<Rating>();
		ratings.add(Rating.A);
		ratings.add(Rating.AAMinus);
		return new RequestRatings(Rating.Defaulting, ratings);
	}
}
