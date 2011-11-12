package at.ac.tuwien.infosys.aic11.dto;

import java.util.Collection;

public class Request {
	private Long id;
	private Long customerId;
	private Collection<Long> warrantorIds;
	private Integer durationYears;
	private String currencyCode;
	private Long amount;
	private String reason;

	public Request() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Collection<Long> getWarrantorIds() {
		return warrantorIds;
	}

	public void setWarrantorIds(Collection<Long> warrantorIds) {
		this.warrantorIds = warrantorIds;
	}

	public Integer getDurationYears() {
		return durationYears;
	}

	public void setDurationYears(Integer durationYears) {
		this.durationYears = durationYears;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", customerId=" + customerId
				+ ", warrantorIds=" + warrantorIds + ", durationYears="
				+ durationYears + ", currencyCode=" + currencyCode
				+ ", amount=" + amount + ", reason=" + reason + "]";
	}
	
	
}
