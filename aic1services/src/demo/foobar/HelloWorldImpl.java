package demo.foobar;

import javax.jws.WebService;

@WebService(endpointInterface = "demo.foobar.HelloWorld",
            serviceName = "HelloWorld",targetNamespace = "demo.foobar.lol")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }

	public DisbursementPreference pushBankTransfer(DisbursementPreference bank) {
		// TODO Auto-generated method stub
		return bank;
	}


}