package aic.shipping;

import java.util.logging.Level;
import java.util.logging.Logger;

import aic.domain.CreditRequest;
import at.ac.tuwien.infosys.aic11.services.*;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Disbursement implements Runnable {
	private DisbursementPreference preference;
	private CreditRequest request;
	private Logger logger = Logger.getLogger("at.ac.tuwien.infosys.aic11.services.Disbursement");

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
			logger.log(Level.SEVERE, "Disbursement service: " + e.getMessage());
		}
		IDisbursementService client = factory.create(IDisbursementService.class);

		try {
			client.startMoneyTransferProcess(preference, request.getMoney(), request.getCustomer());
		}
		catch(InvalidParameterException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Disbursement service: " + e.getMessage());
		}
	}
}
