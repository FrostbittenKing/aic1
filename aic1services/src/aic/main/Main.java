package aic.main;

import aic.rating.RatingService;
import aic.rating.RatingServiceImpl;
import demo.foobar.HelloWorldImpl;
import org.apache.cxf.binding.http.HttpBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.invoker.BeanInvoker;
import org.codehaus.jettison.mapped.MappedXMLInputFactory;
import org.codehaus.jettison.mapped.MappedXMLOutputFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.ws.Endpoint;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(RatingService.class);
		sf.setResourceProvider(RatingService.class,
		                       new SingletonResourceProvider(new RatingServiceImpl()));
		sf.setAddress("http://localhost:8000/");

		sf.create();
		System.out.println("Server ready...");

		Thread.sleep(5 * 60 * 1000);
		System.out.println("Server exiting");
		System.exit(0);
	}
}
