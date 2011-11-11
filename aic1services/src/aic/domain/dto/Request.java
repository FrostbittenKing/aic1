package aic.domain.dto;

import java.util.Collection;

public class Request {
	private long id;
	private long customerId;
	private Collection<Long> warrantorIds;
	private int durationYears;
	private String currencyCode;
	private long amount;
	private String reason;

	public Request() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Collection<Long> getWarrantorIds() {
		return warrantorIds;
	}

	public void setWarrantorIds(Collection<Long> warrantorIds) {
		this.warrantorIds = warrantorIds;
	}

	public int getDurationYears() {
		return durationYears;
	}

	public void setDurationYears(int durationYears) {
		this.durationYears = durationYears;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
