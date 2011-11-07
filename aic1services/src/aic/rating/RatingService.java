package aic.rating;

import aic.domain.dto.RequestRatings;

public interface RatingService {
	/**
	 * Get the ratings for a given request
	 * @param requestId
	 * @return The ratings of the requests customer and his warrantors
	 */
	public RequestRatings getRequestRatings(long requestId);
}
