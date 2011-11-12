package aic.shipping;

import aic.domain.NoSuchRequestException;
import at.ac.tuwien.infosys.aic11.dto.Request;
import at.ac.tuwien.infosys.aic11.services.DisbursementPreference;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style= SOAPBinding.Style.DOCUMENT)
public interface ShippingService {
	@WebMethod
	public void ship(
			@WebParam(name = "request", targetNamespace = "")
			Request request,
			@WebParam(name = "preference", targetNamespace = "")
			DisbursementPreference preference) throws NoSuchRequestException;
}
