package aic.mock;

public class MockFactory {
	private static MockFactory instance = new MockFactory();
	
	
	public static MockFactory instance(){
		return instance;
	}

}
