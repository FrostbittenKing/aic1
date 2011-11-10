package aic.domain.dto;

import aic.domain.Rating;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement
public class RequestRatings {
	private Rating customerRating;
	private Collection<Rating> warrantorRatings;

	public RequestRatings() {
	}

	public RequestRatings(Rating customerRating, Collection<Rating> warrantorRatings) {
		this.customerRating = customerRating;
		this.warrantorRatings = warrantorRatings;
	}

	public Rating getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(Rating customerRating) {
		this.customerRating = customerRating;
	}

	public Collection<Rating> getWarrantorRatings() {
		return warrantorRatings;
	}

	public void setWarrantorRatings(Collection<Rating> warrantorRatings) {
		this.warrantorRatings = warrantorRatings;
	}
}
