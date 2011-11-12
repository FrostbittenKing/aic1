package aic.shipping;

import aic.domain.CreditRequest;
import at.ac.tuwien.infosys.aic11.services.*;
import at.ac.tuwien.infosys.aic11.services.Customer;
import at.ac.tuwien.infosys.aic11.services.IDisbursementService;
import at.ac.tuwien.infosys.aic11.services.Money;
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

		Customer customer = new Customer();
		Address address = new Address();
		address.setStreet(request.getCustomer().getAddress());
		customer.setAddress(address);
		customer.setCustomerId(request.getCustomer().getId());
		customer.setFirstName(request.getCustomer().getName());

		Money money = new Money();
		money.setAmount(request.getMoney().getAmount());
		money.setCurrencyCode(request.getMoney().getCurrencyCode());

		try {
			client.startMoneyTransferProcess(preference, money, customer);
		}
		catch(InvalidParameterException e) {
			e.printStackTrace();
			//todo : log error
		}
	}
}
