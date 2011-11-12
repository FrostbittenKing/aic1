package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.0
 * 2011-11-12T18:32:07.951+01:00
 * Generated source version: 2.5.0
 *
 */
@WebService(targetNamespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "IDisbursementService")
public interface IDisbursementService {

    @RequestWrapper(localName = "start_money_transfer_process", targetNamespace = "http://services.aic11.infosys.tuwien.ac.at/", className = "at.ac.tuwien.infosys.aic11.services.StartMoneyTransferProcess")
    @WebMethod(operationName = "start_money_transfer_process")
    @ResponseWrapper(localName = "start_money_transfer_processResponse", targetNamespace = "http://services.aic11.infosys.tuwien.ac.at/", className = "at.ac.tuwien.infosys.aic11.services.StartMoneyTransferProcessResponse")
    public void startMoneyTransferProcess(
        @WebParam(name = "arg0", targetNamespace = "")
        at.ac.tuwien.infosys.aic11.services.DisbursementPreference arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Money arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        Customer arg2
    ) throws at.ac.tuwien.infosys.aic11.services.InvalidParameterException;
}