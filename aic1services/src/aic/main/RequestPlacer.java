package aic.main;

import aic.contract.ContractService;
import aic.domain.NoSuchCustomerException;
import at.ac.tuwien.infosys.aic11.dto.Request;
import at.ac.tuwien.infosys.aic11.dto.RequestRatings;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.util.Collection;
import java.util.LinkedList;

public class RequestPlacer {
	public static void main(String args[]) throws Exception {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setAddress("http://localhost:9000/helloWorld");
		ContractService client = factory.create(ContractService.class);

		Request r = new Request();
		r.setAmount(100l);
		r.setCurrencyCode("an392");
		r.setCustomerId(0l);
		r.setDurationYears(24);
		r.setReason("rofl");
		Collection<Long> warrantors = new LinkedList<Long>();
		warrantors.add(1l);
		warrantors.add(2l);
		r.setWarrantorIds(warrantors);
		
		try {
			r = client.placeRequest(r);
			System.out.println(r.getId());
			WebClient webClient = WebClient.create("http://localhost:8000");
			webClient.path("rating/" + r.getId());
			webClient.accept("text/html,application/xhtml+xml,application/xml");
			webClient.acceptEncoding("gzip, deflate");
			webClient.get(RequestRatings.class);
		}
		catch(NoSuchCustomerException e) {
			e.printStackTrace();
		}
	}
}
