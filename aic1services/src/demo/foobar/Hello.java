package demo.foobar;

import javax.xml.ws.Endpoint;

public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting Server");
		HelloWorldImpl implementor = new HelloWorldImpl();
		String address = "http://localhost:9000/helloWorld";
		Endpoint.publish(address, implementor);
	}

}
