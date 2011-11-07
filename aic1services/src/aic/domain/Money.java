package aic.domain;

public class Money {
	private String currencyCode;
	private long amount;

	public Money(String currencyCode, long amount) {
		this.currencyCode = currencyCode;
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public long getAmount() {
		return amount;
	}
}
