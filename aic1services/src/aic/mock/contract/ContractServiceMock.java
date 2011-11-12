package aic.mock.contract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import aic.domain.CreditRequest;
import aic.domain.Customer;
import aic.domain.Money;
import aic.domain.NoSuchCustomerException;
import aic.domain.NoSuchOfferException;
import aic.domain.NoSuchRequestException;
import aic.domain.Offer;
import aic.domain.OfferNotOpenException;
import aic.domain.OfferStatus;

public class ContractServiceMock {
	private HashMap<Long, CreditRequest> creditRequests = new HashMap<Long, CreditRequest>();
	private HashMap<Long, Customer> customers = new HashMap<Long, Customer>();

	
	
	public CreditRequest placeRequest(long customerId, Collection<Long> warrantorIds, int durationYears, Money money, String reason) throws NoSuchCustomerException{
		if (customers.get(customerId) == null){
			throw new NoSuchCustomerException();
		}
		CreditRequest request = new CreditRequest(
				customers.get(customerId), 
				getWarrantors(warrantorIds), 
				new ArrayList<Offer>(), 
				durationYears, 
				money, 
				reason);
		creditRequests.put(request.getId(), request);
		generateOffersForRequest(request);
		return request;
	}
	
	private ArrayList<Customer> getWarrantors(Collection<Long> warrantorIds) throws NoSuchCustomerException{
		ArrayList<Customer> warrantors = new ArrayList<Customer>();
		for (Iterator<Long> iterator = warrantorIds.iterator(); iterator.hasNext();){
			Long currentWarrantorId = iterator.next();
			if (customers.get(currentWarrantorId) != null){
				warrantors.add(customers.get(currentWarrantorId));
			}
			else {
				throw new NoSuchCustomerException();
			}
		}
		return warrantors;
	}
	
	private void generateOffersForRequest(CreditRequest request){
		//TODO: generate new offers for credit request
	}
	
	private void declineOldOffersForRequest(CreditRequest request){
		//TODO: set all old offers to declined
	}
	
	public CreditRequest changeRequest(long requestId, int durationYears, Money money, String reason) throws NoSuchRequestException{
		CreditRequest request = creditRequests.get(requestId);
		if (request == null){
			throw new NoSuchRequestException();
		}
		
		request.setDurationYears(durationYears);
		request.setMoney(money);
		request.setReason(reason);
		
		declineOldOffersForRequest(request);
		generateOffersForRequest(request);
		return request;
	}
	
	public Offer getOpenOffer(long requestId) throws NoSuchRequestException{
		CreditRequest request = creditRequests.get(requestId);
		if (request == null){
			throw new NoSuchRequestException();
		}
		Offer currentOffer = null;
		for(Iterator<Offer> iterator = request.getOffers().iterator(); iterator.hasNext();){
			currentOffer = iterator.next();
			if (currentOffer.getStatus() == OfferStatus.Open){
				break;
			}
		}
		return currentOffer;
	}
	
	public void acceptOffer(long offerId) throws NoSuchOfferException, OfferNotOpenException{
		updateOffer(offerId, OfferStatus.Accepted);
	}
	
	public void declineOffer(long offerId) throws NoSuchOfferException, OfferNotOpenException{
		 updateOffer(offerId, OfferStatus.Declined);
	}

	private void updateOffer(long offerId,OfferStatus status) throws OfferNotOpenException,
			NoSuchOfferException {
		Offer currentOffer = null;
		for(Iterator<CreditRequest> requestIterator = creditRequests.values().iterator(); requestIterator.hasNext();){
			for(Iterator<Offer> offerIterator = requestIterator.next().getOffers().iterator(); offerIterator.hasNext();){
				currentOffer = offerIterator.next();
				if (currentOffer.getId() == offerId){
					if (currentOffer.getStatus() != OfferStatus.Open){
						throw new OfferNotOpenException();
					}
					currentOffer.setStatus(status);
					return;
				}
			}
		}
		throw new NoSuchOfferException();
	}
}
