package aic.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import aic.domain.CreditRequest;
import aic.domain.NoSuchCustomerException;
import aic.domain.NoSuchOfferException;
import aic.domain.NoSuchRequestException;
import aic.domain.Offer;
import aic.domain.OfferNotOpenException;
import aic.domain.OfferStatus;
import aic.domain.Rating;
import at.ac.tuwien.infosys.aic11.dto.RequestRatings;
import at.ac.tuwien.infosys.aic11.services.Address;
import at.ac.tuwien.infosys.aic11.services.Customer;
import at.ac.tuwien.infosys.aic11.services.Money;

public class ServiceMock {
	private static ServiceMock instance = null;

	private HashMap<Long, CreditRequest> creditRequests = new HashMap<Long, CreditRequest>();
	private HashMap<Long, Customer> customers = new HashMap<Long, Customer>();
	private HashMap<Long, Rating> customerRatings = new HashMap<Long, Rating>();

	private Random generator = new Random();

	private ServiceMock() {
		Address address = new Address();
		address.setCity("pwntown");
		address.setCountryCode("US");
		address.setDoor("1337");
		address.setHouse("house of awesome");
		address.setPostalCode("9001");
		address.setStreet("unicornstreet");
		for(long i = 0; i <= 3; i++) {
			customers.put(i,
					new Customer());
			customers.get(i).setCustomerId(i);
			customers.get(i).setFirstName("loller"+i);
			customers.get(i).setMiddleName("skater"+i);
			customers.get(i).setLastName("roflcopter"+i);
			customers.get(i).setAddress(address);
			customerRatings.put(i, Rating.AAA);
		}
		
	}

	public CreditRequest placeRequest(long customerId, Collection<Long> warrantorIds, int durationYears, Money money, String reason) throws NoSuchCustomerException {
		if(customers.get(customerId) == null) {
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

	private ArrayList<Customer> getWarrantors(Collection<Long> warrantorIds) throws NoSuchCustomerException {
		ArrayList<Customer> warrantors = new ArrayList<Customer>();
		for(Iterator<Long> iterator = warrantorIds.iterator(); iterator.hasNext();) {
			Long currentWarrantorId = iterator.next();
			if(customers.get(currentWarrantorId) != null) {
				warrantors.add(customers.get(currentWarrantorId));
			}
			else {
				throw new NoSuchCustomerException();
			}
		}
		return warrantors;
	}

	private void generateOfferForRequest(CreditRequest request) {
		request.getOffers().add(new Offer(System.currentTimeMillis(),
		                                  request,
		                                  OfferStatus.Open,
		                                  "random request ",
		                                  generator.nextDouble()));
	}

	private void declineOldOffersForRequest(CreditRequest request) {
		Offer currentOffer = null;
		for(Iterator<Offer> iterator = request.getOffers().iterator(); iterator.hasNext();) {
			currentOffer = iterator.next();
			if(currentOffer.getStatus() == OfferStatus.Open) {
				currentOffer.setStatus(OfferStatus.Declined);
			}
		}
	}

	public CreditRequest changeRequest(long requestId, Integer durationYears, Money money, String reason) throws NoSuchRequestException {
		CreditRequest request = creditRequests.get(requestId);
		if(request == null) {
			throw new NoSuchRequestException();
		}

		boolean change = false;
		if(durationYears != null) {
			change = true;
			request.setDurationYears(durationYears);
		}
		if(money != null) {
			change = true;
			request.setMoney(money);
		}
		if(reason != null) {
			change = true;
			request.setReason(reason);
		}

		if(change) {
			declineOldOffersForRequest(request);
			generateOfferForRequest(request);
		}

		return request;
	}

	public Offer getOpenOffer(long requestId) throws NoSuchRequestException {
		CreditRequest request = creditRequests.get(requestId);
		if(request == null) {
			throw new NoSuchRequestException();
		}
		Offer currentOffer = null;
		for(Iterator<Offer> iterator = request.getOffers().iterator(); iterator.hasNext();) {
			currentOffer = iterator.next();
			if(currentOffer.getStatus() == OfferStatus.Open) {
				break;
			}
		}
		return currentOffer;
	}

	public void acceptOffer(long offerId) throws NoSuchOfferException, OfferNotOpenException {
		Offer currentOffer = null;
		for(Iterator<CreditRequest> requestIterator = creditRequests.values().iterator(); requestIterator.hasNext();) {
			for(Iterator<Offer> offerIterator = requestIterator.next().getOffers().iterator(); offerIterator.hasNext();) {
				currentOffer = offerIterator.next();
				if(currentOffer.getId() == offerId) {
					if(currentOffer.getStatus() != OfferStatus.Open) {
						throw new OfferNotOpenException();
					}
					currentOffer.setStatus(OfferStatus.Accepted);
					return;
				}
			}
		}
		throw new NoSuchOfferException();
	}

	public void declineOffer(long offerId) throws NoSuchOfferException, OfferNotOpenException {
		Offer currentOffer = null;
		for(Iterator<CreditRequest> requestIterator = creditRequests.values().iterator(); requestIterator.hasNext();) {
			for(Iterator<Offer> offerIterator = requestIterator.next().getOffers().iterator(); offerIterator.hasNext();) {
				currentOffer = offerIterator.next();
				if(currentOffer.getId() == offerId) {
					if(currentOffer.getStatus() != OfferStatus.Open) {
						throw new OfferNotOpenException();
					}
					currentOffer.setStatus(OfferStatus.Declined);
					return;
				}
			}
		}
		throw new NoSuchOfferException();
	}

	public RequestRatings getRequestRatings(long requestId) throws NoSuchRequestException {
		CreditRequest request = creditRequests.get(requestId);
		if(request == null) {
			throw new NoSuchRequestException();
		}

		ArrayList<Rating> warrantorRatings = new ArrayList<Rating>();
		for(Iterator<Customer> iterator = request.getWarrantors().iterator(); iterator.hasNext();) {
			warrantorRatings.add(customerRatings.get(iterator.next().getCustomerId()));
		}
		RequestRatings ratings = new RequestRatings(
				customerRatings.get(request.getCustomer().getCustomerId()),
				warrantorRatings);
		return ratings;
	}

	public static ServiceMock getInstance() {
		if(instance == null) {
			instance = new ServiceMock();
		}
		return instance;
	}

	public CreditRequest getRequest(Long id) {
		//todo
		return null;
	}
}
