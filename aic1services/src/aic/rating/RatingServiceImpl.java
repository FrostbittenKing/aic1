package aic.rating;

import aic.domain.NoSuchRequestException;
import aic.mock.ServiceMock;
import at.ac.tuwien.infosys.aic11.dto.RequestRatings;

import javax.ws.rs.PathParam;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatingServiceImpl implements RatingService {
	private Logger logger = Logger.getLogger("ac.at.tuwien.infosys.ac11.services.RatingServiceImpl");
	public RequestRatings getRequestRatings(@PathParam("id") long requestId) {
		logger.log(Level.INFO, "Service requestRatings called for requestId: " + requestId);
		RequestRatings ratings = null;
		try {
			ratings = ServiceMock.getInstance().getRequestRatings(requestId);
		}
		catch (NoSuchRequestException e) {
			logger.log(Level.SEVERE, "Service requestRatings failed, could not find requestId: " + requestId);
		}
		logger.log(Level.INFO, "Service requestRatings returning ratings for request Id: " + requestId + " " + ratings.toString());
		return ratings;
	}
}
