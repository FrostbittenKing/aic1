package aic.domain.dto;

import aic.domain.Rating;

import java.util.Collection;

public class RequestRatings {
	private Rating customerRating;
	private Collection<Rating> warrantorRatings;

	public RequestRatings(Rating customerRating, Collection<Rating> warrantorRatings) {
		this.customerRating = customerRating;
		this.warrantorRatings = warrantorRatings;
	}

	public Rating getCustomerRating() {
		return customerRating;
	}

	public Collection<Rating> getWarrantorRatings() {
		return warrantorRatings;
	}
}
