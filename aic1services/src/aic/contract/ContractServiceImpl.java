package aic.contract;

import aic.domain.*;
import aic.domain.dto.*;
import aic.domain.dto.Offer;

import javax.jws.WebParam;

public class ContractServiceImpl implements ContractService {
	public Offer placeRequest(@WebParam(name = "request", targetNamespace = "") Request request) throws NoSuchCustomerException {
		Offer mock = new Offer();
		mock.setComment("some star fish are hermaphrodites");
		mock.setId(666);
		mock.setRequestId(444);
		mock.setRate(9001d);
		return mock;
	}

	public Offer changeRequest(@WebParam(name = "request", targetNamespace = "") Request request) throws NoSuchRequestException {
		Offer mock = new Offer();
		mock.setComment("other star fish turn from males into females as they mature");
		mock.setId(666);
		mock.setRequestId(444);
		mock.setRate(5.2352d);
		return mock;
	}

	public void acceptOffer(
			@WebParam(name = "offer", targetNamespace = "")
			Offer offer) throws NoSuchOfferException, OfferNotOpenException {
		return;
	}

	public void declineOffer(
			@WebParam(name = "offer", targetNamespace = "")
			Offer offer) throws NoSuchOfferException, OfferNotOpenException {
		return;
	}
}
