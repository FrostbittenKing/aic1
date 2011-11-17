package at.ac.tuwien.infosys.aic11;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import aic.contract.ContractService;
import aic.domain.NoSuchCustomerException;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.dto.Request;


public class Clerk {
	private static final Clerk _instance = new Clerk();
	private JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	private ContractService contractService;
	
	private Clerk() {
		factory.setAddress("http://localhost:9000/helloWorld");
		contractService = factory.create(ContractService.class);
	}
	
	public static Clerk getInstance() {
		return _instance;
	}
	
	public Request createRequest(Request request) throws NoSuchCustomerException{
			return contractService.placeRequest(request);
	}
}
