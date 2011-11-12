package aic.shipping;

import aic.domain.NoSuchCustomerException;
import aic.domain.NoSuchOfferException;
import aic.domain.NoSuchRequestException;
import aic.domain.OfferNotOpenException;
import aic.domain.dto.Offer;
import aic.domain.dto.Request;
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
