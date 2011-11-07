package aic.domain;

import java.util.Collection;

public class CreditRequest {
	private long id;
	private Customer customer;
	private Collection<Customer> warrantors;
	private Collection<Offer> offers;
	private int durationYears;
	private Money money;
	private String reason;
	private boolean closed;
	private RequestChangedListener requestChangedListener;

	public CreditRequest(Customer customer, Collection<Customer> warrantors, Collection<Offer> offers, int durationYears, Money money, String reason) {
		this.customer = customer;
		this.warrantors = warrantors;
		this.offers = offers;
		this.durationYears = durationYears;
		this.money = money;
		this.reason = reason;
	}

	public void setRequestChangedListener(RequestChangedListener requestChangedListener) {
		this.requestChangedListener = requestChangedListener;
	}

	public Collection<Offer> getOffers() {
		return offers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Collection<Customer> getWarrantors() {
		return warrantors;
	}

	public int getDurationYears() {
		return durationYears;
	}

	public void changeDurationYears(int durationYears) throws RequestAlreadyClosedException {
		if(closed) {
			throw new RequestAlreadyClosedException();
		}
		this.durationYears = durationYears;
		requestChangedListener.requestChanged(this);
	}

	public Money getMoney() {
		return money;
	}

	public void changeMoney(Money money) throws RequestAlreadyClosedException {
		if(closed) {
			throw new RequestAlreadyClosedException();
		}
		this.money = money;
		requestChangedListener.requestChanged(this);
	}

	public String getReason() {
		return reason;
	}

	public void changeReason(String reason) throws RequestAlreadyClosedException {
		if(closed) {
			throw new RequestAlreadyClosedException();
		}
		this.reason = reason;
		requestChangedListener.requestChanged(this);
	}

	public long getId() {
		return id;
	}

	public boolean isClosed() {
		return closed;
	}
}
