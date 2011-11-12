package aic.shipping;

import aic.domain.NoSuchRequestException;
import at.ac.tuwien.infosys.aic11.dto.Request;
import aic.mock.ServiceMock;
import at.ac.tuwien.infosys.aic11.services.DisbursementPreference;

import javax.jws.WebParam;

public class ShippingServiceImpl implements ShippingService {
	public void ship(@WebParam(name = "request", targetNamespace = "") Request request, @WebParam(name = "preference", targetNamespace = "") DisbursementPreference preference) throws NoSuchRequestException {
		Thread disbursement = new Thread(new Disbursement(preference, ServiceMock.getInstance().getRequest(request.getId())));
		Thread shipping = new Thread(new Shipping());

		disbursement.start();
		shipping.start();
	}
}
