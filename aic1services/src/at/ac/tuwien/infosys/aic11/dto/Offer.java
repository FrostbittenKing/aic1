package at.ac.tuwien.infosys.aic11.dto;

import aic.domain.CreditRequest;
import aic.domain.OfferStatus;

public class Offer {
	private long id;
	private long requestId;
	private String comment;
	private double rate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", requestId=" + requestId + ", comment="
				+ comment + ", rate=" + rate + "]";
	}
}
