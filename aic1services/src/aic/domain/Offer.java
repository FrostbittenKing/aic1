package aic.domain;

public class Offer {
	private long id;
	private CreditRequest request;
	private OfferStatus status;
	private String comment;
	private double rate;

	public Offer(long id, CreditRequest request, OfferStatus status, String comment, double rate) {
		this.id = id;
		this.request = request;
		this.status = status;
		this.comment = comment;
		this.rate = rate;
	}

	public long getId() {
		return id;
	}

	public CreditRequest getRequest() {
		return request;
	}

	public OfferStatus getStatus() {
		return status;
	}

	void setStatus(OfferStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public double getRate() {
		return rate;
	}
}
