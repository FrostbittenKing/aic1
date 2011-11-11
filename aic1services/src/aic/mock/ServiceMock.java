package aic.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import aic.domain.CreditRequest;
import aic.domain.Customer;
import aic.domain.Money;
import aic.domain.NoSuchCustomerException;
import aic.domain.NoSuchOfferException;
import aic.domain.NoSuchRequestException;
import aic.domain.Offer;
import aic.domain.OfferNotOpenException;
import aic.domain.OfferStatus;
import aic.domain.Rating;
import aic.domain.dto.RequestRatings;

public class ServiceMock {
	private HashMap<Long, CreditRequest> creditRequests = new HashMap<Long, CreditRequest>();
	private HashMap<Long, Customer> customers = new HashMap<Long, Customer>();
	
	private Random generator = new Random();
	
	public ServiceMock(){
		for (long i = 0; i <= 3; i++){
			customers.put(
					i,
					new Customer(
							i, 
							"customer " + i,
							new BigDecimal(generator.nextDouble()),
							"lolstreet " + i,
							Rating.AAA));
		}
	}
	
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
		generateOfferForRequest(request);
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
	
	private void generateOfferForRequest(CreditRequest request){
		request.getOffers().add(new Offer(System.currentTimeMillis(),
										request, 
										OfferStatus.Open, 
										"random request ", 
										generator.nextDouble()));
	}
	
	private void declineOldOffersForRequest(CreditRequest request){
		Offer currentOffer = null;
		for(Iterator<Offer> iterator = request.getOffers().iterator(); iterator.hasNext();){
			currentOffer = iterator.next();
			if (currentOffer.getStatus() == OfferStatus.Open){
				currentOffer.setStatus(OfferStatus.Declined);
			}
		}
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
		generateOfferForRequest(request);
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
		Offer currentOffer = null;
		for(Iterator<CreditRequest> requestIterator = creditRequests.values().iterator(); requestIterator.hasNext();){
			for(Iterator<Offer> offerIterator = requestIterator.next().getOffers().iterator(); offerIterator.hasNext();){
				currentOffer = offerIterator.next();
				if (currentOffer.getId() == offerId){
					if (currentOffer.getStatus() != OfferStatus.Open){
						throw new OfferNotOpenException();
					}
					currentOffer.setStatus(OfferStatus.Accepted);
					return;
				}
			}
		}
		throw new NoSuchOfferException();
	}
	
	public void declineOffer(long offerId) throws NoSuchOfferException, OfferNotOpenException{
		Offer currentOffer = null;
		for(Iterator<CreditRequest> requestIterator = creditRequests.values().iterator(); requestIterator.hasNext();){
			for(Iterator<Offer> offerIterator = requestIterator.next().getOffers().iterator(); offerIterator.hasNext();){
				currentOffer = offerIterator.next();
				if (currentOffer.getId() == offerId){
					if (currentOffer.getStatus() != OfferStatus.Open){
						throw new OfferNotOpenException();
					}
					currentOffer.setStatus(OfferStatus.Declined);
					return;
				}
			}
		}
		throw new NoSuchOfferException();
	}
	
	public RequestRatings getRequestRatings(long requestId) throws NoSuchRequestException{
		CreditRequest request = creditRequests.get(requestId);
		if (request == null){
			throw new NoSuchRequestException();
		}
		
		ArrayList<Rating> warrantorRatings = new ArrayList<Rating>();
		for(Iterator<Customer> iterator = request.getWarrantors().iterator(); iterator.hasNext();){
			warrantorRatings.add(iterator.next().getRating());
		}
		 RequestRatings ratings = new RequestRatings(
				 						request.getCustomer().getRating(),
				 						warrantorRatings);
		return ratings;
	}
}
