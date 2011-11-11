package aic.domain;

import java.math.BigDecimal;

public class Customer {
	private long id;
	private String name;
	private BigDecimal openBalance;
	private String address;
	private Rating rating;

	public Customer() {
	}

	public Customer(long id, String name, BigDecimal openBalance,
			String address, Rating rating) {
		this.id = id;
		this.name = name;
		this.openBalance = openBalance;
		this.address = address;
		this.rating = rating;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOpenBalance() {
		return openBalance;
	}

	public void setOpenBalance(BigDecimal openBalance) {
		this.openBalance = openBalance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
