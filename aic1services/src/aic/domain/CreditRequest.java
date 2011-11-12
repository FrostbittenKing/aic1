package aic.domain;

import at.ac.tuwien.infosys.aic11.services.Customer;
import at.ac.tuwien.infosys.aic11.services.Money;

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

	public CreditRequest(Customer customer, Collection<Customer> warrantors, Collection<Offer> offers, int durationYears, Money money, String reason) {
		this.id = System.currentTimeMillis();
		this.customer = customer;
		this.warrantors = warrantors;
		this.offers = offers;
		this.durationYears = durationYears;
		this.money = money;
		this.reason = reason;
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

	public Money getMoney() {
		return money;
	}

	public void setDurationYears(int durationYears) {
		this.durationYears = durationYears;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public long getId() {
		return id;
	}

	public boolean isClosed() {
		return closed;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditRequest other = (CreditRequest) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
