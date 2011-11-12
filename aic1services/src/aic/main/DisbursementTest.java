package aic.main;

import aic.contract.ContractService;
import aic.domain.NoSuchCustomerException;
import aic.domain.dto.Request;
import at.ac.tuwien.infosys.aic11.services.Cheque;
import at.ac.tuwien.infosys.aic11.services.IRegistryService_RegistryService_Client;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.*;

import javax.xml.namespace.QName;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DisbursementTest {
	public static void main(String args[]) throws Exception {
		Cheque c = new Cheque();
		c.setName("lol");

		URL wsdlURL = new URL(IRegistryService_RegistryService_Client.getEndpoint(c).getLocation());

		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient(wsdlURL);
		Object[] res = client.invoke("echo", "test echo");
		System.out.println("Echo response: " + res[0]);
	}
}
