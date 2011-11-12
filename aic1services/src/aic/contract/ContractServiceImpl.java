package aic.contract;

import aic.domain.*;
import aic.domain.dto.*;
import aic.domain.dto.Offer;
import aic.mock.ServiceMock;

import javax.jws.WebParam;

public class ContractServiceImpl implements ContractService {
	public Offer placeRequest(@WebParam(name = "request", targetNamespace = "") Request request) throws NoSuchCustomerException {
		CreditRequest placedRequest =
				ServiceMock.getInstance().placeRequest(
						request.getCustomerId(),
						request.getWarrantorIds(),
						request.getDurationYears(),
						new Money(request.getCurrencyCode(), request.getAmount()),
						request.getReason());
		aic.domain.Offer requestOffer = null;
		try {
			requestOffer = ServiceMock.getInstance().getOpenOffer(placedRequest.getId());
		}
		catch(NoSuchRequestException e) {
			assert false;
		}

		return buildOfferDTO(requestOffer);
	}

	public Offer changeRequest(@WebParam(name = "request", targetNamespace = "") Request request) throws NoSuchRequestException {
		CreditRequest updatedRequest = ServiceMock.getInstance().changeRequest(
				request.getId(),
				request.getDurationYears(),
				(request.getCurrencyCode() != null && request.getAmount() != null) ? new Money(request.getCurrencyCode(), request.getAmount()) : null,
				request.getReason()
		);

		aic.domain.Offer requestOffer = null;
		try {
			requestOffer = ServiceMock.getInstance().getOpenOffer(updatedRequest.getId());
		}
		catch(NoSuchRequestException e) {
			assert false;
		}

		return buildOfferDTO(requestOffer);
	}

	private Offer buildOfferDTO(aic.domain.Offer offer) {
		Offer dto = new Offer();
		dto.setComment(offer.getComment());
		dto.setId(offer.getId());
		dto.setRequestId(offer.getRequest().getId());
		dto.setRate(offer.getRate());
		return dto;
	}

	public void acceptOffer(
			@WebParam(name = "offer", targetNamespace = "")
			Offer offer) throws NoSuchOfferException, OfferNotOpenException {
		ServiceMock.getInstance().acceptOffer(offer.getId());
	}

	public void declineOffer(
			@WebParam(name = "offer", targetNamespace = "")
			Offer offer) throws NoSuchOfferException, OfferNotOpenException {
		ServiceMock.getInstance().declineOffer(offer.getId());
	}
}
