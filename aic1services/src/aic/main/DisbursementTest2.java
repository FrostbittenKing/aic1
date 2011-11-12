package aic.main;

import at.ac.tuwien.infosys.aic11.services.Address;
import at.ac.tuwien.infosys.aic11.services.Customer;
import at.ac.tuwien.infosys.aic11.services.IDisbursementService;
import at.ac.tuwien.infosys.aic11.services.Money;
import at.ac.tuwien.infosys.aic11.services.*;
import at.ac.tuwien.infosys.aic11.services.BankTransfer;
import at.ac.tuwien.infosys.aic11.services.Cheque;
import at.ac.tuwien.infosys.aic11.services.DisbursementPreference;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class DisbursementTest2 {
	public static void main(String[] args) throws Exception {
		Cheque c = new Cheque();
		c.setName("lol");

		BankTransfer bt = new BankTransfer();
		bt.setBic("roflbic");
		bt.setBankName("roflbank");
		bt.setIban("rofliban");

		DisbursementPreference pref = bt;

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setAddress(IRegistryService_RegistryService_Client.getEndpoint(pref).getLocation());
		IDisbursementService client = factory.create(IDisbursementService.class);

		Customer customer = new Customer();
		customer.setAddress(new Address());

		client.startMoneyTransferProcess(pref, new Money(), customer);
	}
}
