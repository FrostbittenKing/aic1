package aic.contract;

import at.ac.tuwien.infosys.aic11.services.DisbursementPreference;

public class Disbursement implements Runnable {
	DisbursementPreference preference;

	public Disbursement(DisbursementPreference preference) {
		this.preference = preference;
	}

	public void run() {

	}
}
