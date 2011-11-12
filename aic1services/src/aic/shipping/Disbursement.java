package aic.shipping;

import aic.domain.CreditRequest;
import at.ac.tuwien.infosys.aic11.services.*;
import at.ac.tuwien.infosys.aic11.services.IDisbursementService;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Disbursement implements Runnable {
	private DisbursementPreference preference;
	private CreditRequest request;

	public Disbursement(DisbursementPreference preference, CreditRequest request) {
		this.preference = preference;
	}

	public void run() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		try {
			factory.setAddress(IRegistryService_RegistryService_Client.getEndpoint(preference).getLocation());
		}
		catch(InvalidParameterException e) {
			e.printStackTrace();
			//todo : log error
		}
		IDisbursementService client = factory.create(IDisbursementService.class);

		try {
			client.startMoneyTransferProcess(preference, request.getMoney(), request.getCustomer());
		}
		catch(InvalidParameterException e) {
			e.printStackTrace();
			//todo : log error
		}
	}
}
