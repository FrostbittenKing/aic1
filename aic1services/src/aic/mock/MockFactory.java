package aic.mock;

import aic.mock.contract.ContractServiceMock;
import aic.mock.rating.RatingServiceMock;

public class MockFactory {
	private static MockFactory instance = new MockFactory();
	
	private ContractServiceMock contractService = null;
	private RatingServiceMock ratingService = null;
	
	public static MockFactory instance(){
		return instance;
	}
	
	
	public ContractServiceMock getContractService(){
		if (contractService == null){
			contractService = new ContractServiceMock();
		}
		return contractService;
	}
	
	public RatingServiceMock getRatingService(){
		if (ratingService == null){
			ratingService = new RatingServiceMock();
		}
		return ratingService;
	}

}
