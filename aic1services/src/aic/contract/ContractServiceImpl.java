package aic.contract;

import aic.domain.*;
import aic.mock.ServiceMock;
import at.ac.tuwien.infosys.aic11.dto.*;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.services.Customer;
import at.ac.tuwien.infosys.aic11.services.Money;

import javax.jws.WebParam;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContractServiceImpl implements ContractService {
	Logger logger = Logger.getLogger("at.ac.tuwien.infosys.ac11.services.ContractServiceImpl");
	public Request placeRequest(@WebParam(name = "request", targetNamespace = "") Request request) throws NoSuchCustomerException {
		logger.log(Level.INFO, "Service placeRequest invoked with request: " + request);
		Money money = new Money();
		money.setAmount(request.getAmount());
		money.setCurrencyCode(request.getCurrencyCode());
		CreditRequest placedRequest =
				ServiceMock.getInstance().placeRequest(
						request.getCustomerId(),
						request.getWarrantorIds(),
						request.getDurationYears(),
						money,
						request.getReason());
		Request returnRequest = buildRequestDTO(placedRequest);
		logger.log(Level.INFO, "Service placeRequest returning placed request: " + returnRequest);
		return returnRequest; 
	}

	public Request changeRequest(@WebParam(name = "request", targetNamespace = "") Request request) throws NoSuchRequestException {
		logger.log(Level.INFO, "Service changeRequest invoked with request: " + request);
		Money money = null;
		if(request.getCurrencyCode() != null && request.getAmount() != null) {
			money = new Money();
			money.setAmount(request.getAmount());
			money.setCurrencyCode(request.getCurrencyCode());
		}

		CreditRequest updatedRequest = ServiceMock.getInstance().changeRequest(
				request.getId(),
				request.getDurationYears(),
				money,
				request.getReason()
		);
		
		Request returnRequest = buildRequestDTO(updatedRequest);
		logger.log(Level.INFO, "Service changeRequest returning placed request: " + returnRequest);
		return returnRequest;
	}

	private static Request buildRequestDTO(CreditRequest ref) {
		Request request = new Request();
		request.setAmount(ref.getMoney().getAmount());
		request.setCurrencyCode(ref.getMoney().getCurrencyCode());
		request.setCustomerId(ref.getCustomer().getCustomerId());
		request.setDurationYears(ref.getDurationYears());
		request.setId(ref.getId());
		request.setReason(ref.getReason());
		Collection<Long> warrantorIds = new LinkedList<Long>();
		for(Customer warrantor : ref.getWarrantors()) {
			warrantorIds.add(warrantor.getCustomerId());
		}
		request.setWarrantorIds(warrantorIds);
		return request;
	}

//	private at.ac.tuwien.infosys.aic11.dto.Offer buildOfferDTO(aic.domain.Offer offer) {
//		at.ac.tuwien.infosys.aic11.dto.Offer dto = new at.ac.tuwien.infosys.aic11.dto.Offer();
//		dto.setComment(offer.getComment());
//		dto.setId(offer.getId());
//		dto.setRequestId(offer.getRequest().getId());
//		dto.setRate(offer.getRate());
//		return dto;
//	}

	public void acceptOffer(
			@WebParam(name = "offer", targetNamespace = "")
			Offer offer) throws NoSuchOfferException, OfferNotOpenException {
		logger.log(Level.INFO, "Service acceptOffer invoked with offer: " + offer);
		ServiceMock.getInstance().acceptOffer(offer.getId());
	}

	public void declineOffer(
			@WebParam(name = "offer", targetNamespace = "")
			Offer offer) throws NoSuchOfferException, OfferNotOpenException {
		logger.log(Level.INFO, "Service declineOffer invoked with offer: " + offer);
		ServiceMock.getInstance().declineOffer(offer.getId());
	}
}
