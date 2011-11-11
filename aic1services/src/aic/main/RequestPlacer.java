package aic.main;

import aic.contract.ContractService;
import aic.domain.NoSuchCustomerException;
import aic.domain.dto.Request;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class RequestPlacer {
	public static void main(String args[]) throws Exception {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setAddress("http://localhost:9000/helloWorld");
		ContractService client = factory.create(ContractService.class);

		Request r = new Request();
		r.setCustomerId(42);
		try {

			System.out.println(client.placeRequest(r).getComment());
		}
		catch(NoSuchCustomerException e) {
			e.printStackTrace();
		}
	}
}
