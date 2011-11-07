package aic.contract;

import aic.domain.*;

import java.util.Collection;

public interface ContractService {
	/**
	 * Places a new request
	 * @param customerId
	 * @param warrantorIds
	 * @param durationYears
	 * @param money
	 * @param reason
	 * @return
	 */
	public CreditRequest placeRequest(long customerId, Collection<Long> warrantorIds, int durationYears, Money money, String reason) throws NoSuchCustomerException;

	/**
	 * Changes a request parameters
	 * @param requestId Id of the request to change
	 * @param durationYears Altered duration or null if no change
	 * @param money Altered money or null if no change
	 * @param reason Altered reason or null if no change
	 * @return Newly updated request
	 */
	public CreditRequest changeRequest(long requestId, Long durationYears, Money money, String reason) throws NoSuchRequestException;

	/**
	 * Get current offer a given request
	 * @param requestId Request to retrieve offers for
	 * @return Open offer for that request or null if no offer has been made yet
	 */
	public Offer getOpenOffer(long requestId) throws NoSuchRequestException;

	/**
	 * Accept an open offer
	 * @param offerId
	 */
	public void acceptOffer(long offerId) throws NoSuchOfferException, OfferNotOpenException;

	/**
	 * Declines an open offer
	 * @param offerId
	 */
	public void declineOffer(long offerId) throws NoSuchOfferException, OfferNotOpenException;
}
