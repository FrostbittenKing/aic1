package demo.foobar;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface HelloWorld {

    String sayHi(@WebParam(name="text")String text);
    DisbursementPreference pushBankTransfer(@WebParam(name="bank")DisbursementPreference bank);
}