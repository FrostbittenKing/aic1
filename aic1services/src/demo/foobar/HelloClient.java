package demo.foobar;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class HelloClient {
	
	public static void main(String args[]) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(HelloWorld.class);
		factory.setAddress("http://localhost:9000/helloWorld");
		HelloWorld client = (HelloWorld) factory.create();
		
		DisbursementPreference bank = new BankTransfer();
		((BankTransfer)bank).bankName = "foo";
		((BankTransfer)bank).bic = "bar";
		((BankTransfer)bank).iban = "roflwafl";
		DisbursementPreference reply = client.pushBankTransfer(bank);
		
		System.out.println("Server said: " + ((BankTransfer)reply).bankName);
		System.exit(0); 
		
	}	
}
