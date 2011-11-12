package aic.shipping;

import java.util.logging.Level;
import java.util.logging.Logger;

import aic.domain.NoSuchRequestException;
import at.ac.tuwien.infosys.aic11.dto.Request;
import aic.mock.ServiceMock;
import at.ac.tuwien.infosys.aic11.services.DisbursementPreference;

import javax.jws.WebParam;

public class ShippingServiceImpl implements ShippingService {
	private Logger logger = Logger.getLogger("at.ac.tuwien.infosys.aic11.services.ShippingServiceImpl");
	public void ship(@WebParam(name = "request", targetNamespace = "") Request request, @WebParam(name = "preference", targetNamespace = "") DisbursementPreference preference) throws NoSuchRequestException {
		logger.log(Level.INFO, "Service ship invoked for request: " + request + " and preference: " + preference);
		Thread disbursement = new Thread(new Disbursement(preference, ServiceMock.getInstance().getRequest(request.getId())));
		Thread shipping = new Thread(new Shipping());

		disbursement.start();
		shipping.start();
	}
}
