package aic1.shipping;

import at.ac.tuwien.infosys.aic11.services.InvalidParameterException;
import at.ac.tuwien.infosys.aic11.services.ObjectFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "ShippingService")
@SOAPBinding(style= SOAPBinding.Style.DOCUMENT)
public interface ShippingService {
    @RequestWrapper(localName = "query", targetNamespace = "http://services.aic11.infosys.tuwien.ac.at/", className = "at.ac.tuwien.infosys.aic11.services.Query")
    @WebMethod
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "http://services.aic11.infosys.tuwien.ac.at/", className = "at.ac.tuwien.infosys.aic11.services.QueryResponse")
    public void query(
        @WebParam(name = "arg0", targetNamespace = "")
        at.ac.tuwien.infosys.aic11.services.DisbursementPreference arg0
    ) throws InvalidParameterException;
}

