package aic.contract;

import aic.domain.NoSuchCustomerException;
import aic.domain.NoSuchOfferException;
import aic.domain.NoSuchRequestException;
import aic.domain.OfferNotOpenException;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.dto.Request;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style= SOAPBinding.Style.DOCUMENT)
public interface ContractService {
	/**
	 * Places a new request
	 * @param request Request to place
	 * @return offer created for the request
	 * @throws aic.domain.NoSuchCustomerException
	 */
	@WebMethod
	public Request placeRequest(
			@WebParam(name = "request", targetNamespace = "")
			Request request) throws NoSuchCustomerException;

	/**
	 * Changes a request parameters
	 * @param request Request with correct id and updated values
	 * @return offer for updated request
	 * @throws aic.domain.NoSuchRequestException
	 */
	@WebMethod
	public Request changeRequest(
			@WebParam(name = "request", targetNamespace = "")
			Request request) throws NoSuchRequestException;

	/**
	 * Accept an open offer
	 * @param offer Offer to accept
	 * @throws aic.domain.NoSuchOfferException
	 * @throws aic.domain.OfferNotOpenException
	 */
	@WebMethod
	public void acceptOffer(
			@WebParam(name = "offer", targetNamespace = "")
			Offer offer) throws NoSuchOfferException, OfferNotOpenException;

	/**
	 * Declines an open offer
	 * @param offer Offer to decline
	 * @throws aic.domain.NoSuchOfferException
	 * @throws aic.domain.OfferNotOpenException
	 */
	@WebMethod
	public void declineOffer(
			@WebParam(name = "offer", targetNamespace = "")
			Offer offer) throws NoSuchOfferException, OfferNotOpenException;
}
