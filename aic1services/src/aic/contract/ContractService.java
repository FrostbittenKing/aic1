package aic.contract;

import aic.domain.NoSuchCustomerException;
import aic.domain.NoSuchOfferException;
import aic.domain.NoSuchRequestException;
import aic.domain.OfferNotOpenException;
import aic.domain.dto.Offer;
import aic.domain.dto.Request;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Collection;

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
	public Offer placeRequest(
			@WebParam(name = "request", targetNamespace = "")
			Request request) throws NoSuchCustomerException;

	/**
	 * Changes a request parameters
	 * @param request Request with correct id and updated values
	 * @return offer for updated request
	 * @throws aic.domain.NoSuchRequestException
	 */
	@WebMethod
	public Offer changeRequest(
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
